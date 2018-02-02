package com.project.action.admin;
 
import java.io.File;
import java.util.Date;
import java.util.UUID;


import com.jfinal.config.Constants;
import com.jfinal.core.Controller;
import com.project.BO.AIndexBO;
import com.project.common.TConstant;
import com.project.model.TInformation;
import com.project.model.TUser;

public class AIndexAction extends Controller{
	  
	public void index(){
		//获取首页焦点图的列表 
		 
		int countNum = 10;
		AIndexBO aib = new AIndexBO(); 
		
		int pageNum =  getParaToInt("pageNum",1);
		
		setAttr("infPage", aib.getTInformationPage(pageNum, countNum));
		renderTemplate("/admin/index.html"); 
	}
	

	public void get_object(){
		
		int id = getParaToInt("id",0); 
		TInformation info = new TInformation().dao().findById(id);
		
		setAttr("info", info);
		
		renderTemplate("/admin/indexAdd.html"); 
	}
	 
	
	public void save(){
		
		Boolean ifTrue = false;
		
		TInformation info = new TInformation();
		
		TUser user = getSessionAttr("loginUser");
		
		getFile();  
		
		//附件的路径
		String newFilePathName = "";
		//id 
		String id = getPara("id",""); 
		//标题
		String postTitle = getPara("postTitle",""); 
		
		String imgFile = getPara("imgFile","");
		
 
		
		if(!id.equals("")){
			info = new TInformation().findById(id);
			
			if (!imgFile.equals(info.getImgFile())){
				String folderName = UUID.randomUUID().toString();  
				getFile(getPara("upFile"), TConstant.INDEX_PHOTO_PATH); //上传
				
				
				if(this.getFile() != null){
					String oldName = this.getFile().getOriginalFileName();  //原上传文件名
					String hz = oldName.substring(oldName.lastIndexOf("."));  //上传文件的后缀名
					
					File file_old = this.getFile().getFile();  //获取上传的文件
					  
					String newFilePathName0 = this.getFile().getUploadPath()+"\\" + TConstant.INDEX_PHOTO_PATH +"\\"+ folderName + hz;  //新名字
					file_old.renameTo(new File(newFilePathName0));  //修改名字
					
					//上传图片的路径
					newFilePathName = new Constants().getBaseUploadPath()+"\\" + TConstant.INDEX_PHOTO_PATH +"\\"+folderName + hz;
				
				}
				info.setImgFile(newFilePathName);
				
			}  
			
			info.setPostTitle(postTitle);
			info.setType(TConstant.INDEX_PHOTO); 
			info.setModifyDate(new Date());
			info.setModifyUse(user.getUsername());
			
			
			ifTrue = info.update();
			
		}else{
			
			String folderName = UUID.randomUUID().toString();  
			getFile(getPara("upFile"), TConstant.INDEX_PHOTO_PATH); //上传
			
			
			String oldName = this.getFile().getOriginalFileName();  //原上传文件名
			String hz = oldName.substring(oldName.lastIndexOf("."));  //上传文件的后缀名
			
			File file_old = this.getFile().getFile();  //获取上传的文件
			  
			String newFilePathName0 = this.getFile().getUploadPath()+"\\" + TConstant.INDEX_PHOTO_PATH +"\\"+ folderName + hz;  //新名字
			file_old.renameTo(new File(newFilePathName0));  //修改名字
			
			//上传图片的路径
		    newFilePathName = new Constants().getBaseUploadPath()+"\\" + TConstant.INDEX_PHOTO_PATH +"\\"+folderName + hz;
			
			
			info.setPostTitle(postTitle);
			info.setType(TConstant.INDEX_PHOTO);
			info.setImgFile(newFilePathName);
			
			info.setCreateDate(new Date());
			info.setCreateUse(user.getUsername());
			
			//保存
		    ifTrue = info.save(); 
		}
		 
		
		 
		
		setAttr("ifTrue", ifTrue);
		
		forwardAction("/admin/index"); 
	}
	
	public void del(){
		
		int id = getParaToInt("id",0); 
	    new TInformation().dao().deleteById(id);
		 
	    forwardAction("/admin/index"); 
	}
	
}







