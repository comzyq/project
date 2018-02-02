package com.project.action.admin;

import java.io.File;
import java.util.UUID;

import com.jfinal.config.Constants;
import com.jfinal.core.Controller;
import com.project.BO.AProductBO;
import com.project.common.TConstant;
import com.project.model.TProducts;

public class AProductAction extends Controller{

	public void index(){
		
 
		String typeCode = getPara("typeCode");
		String typeJump = getPara("typeJump");
		 
		int countNum = 10;
		AProductBO apb = new AProductBO(); 
		
		int pageNum =  getParaToInt("pageNum",1);
		
		setAttr("typeCode", typeCode);
		
		setAttr("apbPage", apb.getTProductsPage(pageNum, countNum, typeCode));
		
		renderTemplate("/admin/"+typeJump+".html"); 
	}
	
	
	public void get_object(){
		
		String id = getPara("id","");   
		String typeJump = getPara("typeJump"); 
		String typeCode = getPara("typeCode");
		
		TProducts product = new TProducts().dao().findById(id);
		

		setAttr("typeCode", typeCode);
		setAttr("typeJump", typeJump);
		setAttr("product", product);
		
		renderTemplate("/admin/"+typeJump+".html"); 
	}
	
	
	public void save(){

		//附件的路径
		String newFilePathName = "";

		getFile();  
		
		String typeJump = getPara("typeJump");
		String typeCode = getPara("typeCode"); 
		String imgFile = getPara("imgFile","");
		 
		TProducts product = getModel(TProducts.class,"product");
		
		if(product.getId() != null && !product.getId().equals("")){
			
			if (!imgFile.equals(product.getPicurl())){
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
					
					product.setPicurl(newFilePathName);
				}
				
			}  
			
			 
			product.update();
		}else{
			
			
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
		    product.setPicurl(newFilePathName);
			
			
			product.save();
		} 
		 
	   setAttr("typeCode", typeCode); 
	   redirect("/admin/product?typeCode="+ typeCode + "&typeJump=" + typeJump); 
	}
	
	public void delObject(){

		String typeJump = getPara("typeJump");
		String typeCode = getPara("typeCode");
		
		int id = getParaToInt("id",0); 
	    new TProducts().dao().deleteById(id);
		 
	    setAttr("typeCode", typeCode); 
	    redirect("/admin/product?typeCode="+ typeCode + "&typeJump=" + typeJump);
	}
	
}
