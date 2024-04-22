package cn.vincent;

import java.io.File;

public class BatchRename {
	
	public static void main(String[] args){
		String path = "C:/Users/Vincent/Desktop/in/VVV";
		getNew(path);
	}
	public static void getNew(String path) {
		File file = new File(path);
		String[] list = file.list();
		if (list!=null && list.length>0){
			for (String oldName:list){
				File oldFile = new File(path, oldName);
				if(!oldFile.isDirectory()){
//					if(oldName.contains(".myjava")){
//						System.out.print(oldName);
//						String newoldName = oldName.substring(0, oldName.lastIndexOf("."))+".java";
//						System.out.print(newoldName);
//						File newFile = new File(path,newoldName);
//						boolean flag = oldFile.renameTo(newFile);
//						System.out.println(flag);
//					}
//					if(oldName.contains(".myproperies")){
//						System.out.print(oldName);
//						String newoldName = oldName.substring(0, oldName.lastIndexOf("."))+".properies";
//						System.out.print(newoldName);
//						File newFile = new File(path,newoldName);
//						boolean flag = oldFile.renameTo(newFile);
//						System.out.println(flag);
//					}
					if(oldName.contains(".mysql")){
						System.out.print(oldName);
						String newoldName = oldName.substring(0, oldName.lastIndexOf("."))+".sql";
						System.out.print(newoldName);
						File newFile = new File(path,newoldName);
						boolean flag = oldFile.renameTo(newFile);
						System.out.println(flag);
					}
					// hexpay
//					if(oldName.contains(".myhtml")){
//						System.out.print(oldName);
//						String newoldName = oldName.substring(0, oldName.lastIndexOf("."))+".html";
//						System.out.print(newoldName);
//						File newFile = new File(path,newoldName);
//						boolean flag = oldFile.renameTo(newFile);
//						System.out.println(flag);
//					}
//					if(oldName.contains(".myjsp")){
//						System.out.print(oldName);
//						String newoldName = oldName.substring(0, oldName.lastIndexOf("."))+".jsp";
//						System.out.print(newoldName);
//						File newFile = new File(path,newoldName);
//						boolean flag = oldFile.renameTo(newFile);
//						System.out.println(flag);
//					}
				}
				else{
					String newpath=path+"/"+oldName;
					getNew(newpath);
				}
			}
		}
	}

}
