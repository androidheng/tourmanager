package com.tourmanager.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import entity.Result;

@Controller
public class UploadController {
	@ResponseBody
	@RequestMapping("/upload")
	public Result upload(MultipartFile file,HttpServletRequest request,HttpServletResponse response,HttpSession session){
	    if (file!=null) {// 判断上传的文件是否为空
            String path=null;// 文件路径
            String type=null;// 文件类型
            String fileName=file.getOriginalFilename();// 文件原名称
            System.out.println("上传的文件原名称:"+fileName);
            // 判断文件类型
            type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
            if (type!=null) {// 判断文件类型是否为空
                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath=request.getSession().getServletContext().getRealPath("upload/");
                    // 自定义的文件名称
                    String trueFileName=String.valueOf(System.currentTimeMillis())+fileName.substring(fileName.indexOf("."));
                    // 设置存放图片文件的路径
                    path=realPath+File.separator+trueFileName;
                    System.out.println("存放图片文件的路径:"+path);
                    // 转存文件到指定的路径
                    try {
						file.transferTo(new File(path));
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    System.out.println("文件成功上传到指定目录下");
                    return new Result(true, "upload/"+trueFileName);
                }else {
                    System.out.println("不是我们想要的文件类型,请按要求重新上传");
                    return new Result(false, "文件类型不正确");
                }
            }else {
                System.out.println("文件类型为空");
                return new Result(false, "文件类型为空");
            }
        }else {
            System.out.println("没有找到相对应的文件");
            return null;
        }
	}
}
