<%@page import="java.util.zip.ZipEntry"%>
<%@page import="java.util.zip.ZipOutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@page import ="java.io.*" %>
	<%
		//디렉토리 경로 확인
		String dirPath = pageContext.getServletContext().getRealPath("/") + "C05내장객체\\download\\";
		System.out.println("PATH : " + dirPath);
		
		try{
			File dir = new File(dirPath); //File dir 경로 설정
			File filelist[] = dir.listFiles(); //dir 안 모들 파일정보를 File 배열형태로 받기
			
			for(int i=0;i<filelist.length;i++){
				System.out.println(filelist[i]);
			}
			
			FileInputStream fin = null;
			ZipEntry zipEntry = null;	//Zip 묶여지는 단일파일 단위 



			//response 전달 파일타입 변경
			response.setHeader("Content-Type","application/octet-stream;charset=utf-8");
			response.setHeader("Content-Disposition","attachment; filename=TEST.zip");
			
			//[오류해결] 이 응답을 위해 getOutputStream()이 이미 호출되었습니다.
			out.clear(); //response outstream 을 닫고 버퍼를 비움 
			out = pageContext.pushBody(); //현재 페이지 body 연결
			
			ServletOutputStream bout = response.getOutputStream();
			
			//추가
			ZipOutputStream zout = new ZipOutputStream(bout);

			for (File file : filelist)
			{
				fin = new FileInputStream(file);
				ZipEntry zip = new ZipEntry(file.getName().toString()); //압축된 파일 하나하나의 이름 구별 단위
				zout.putNextEntry(zip);

				while (true) 
				{
					int data = fin.read();
					if (data == -1)
						break;
					zout.write((byte) data);
				}
				
				zout.closeEntry();
				fin.close();
			}
			zout.close();
		} catch (Exception e) {

		}

		
	%>

</body>
</html>