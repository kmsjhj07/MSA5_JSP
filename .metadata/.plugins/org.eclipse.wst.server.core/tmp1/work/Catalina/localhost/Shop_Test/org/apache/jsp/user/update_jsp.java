/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.100
 * Generated at: 2024-04-29 05:46:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import shop.dao.UserRepository;
import shop.dto.User;

public final class update_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(2);
    _jspx_imports_classes.add("shop.dto.User");
    _jspx_imports_classes.add("shop.dao.UserRepository");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("	<meta charset=\"UTF-8\">\r\n");
      out.write("	<title>Shop</title>\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/layout/meta.jsp", out, false);
      out.write(' ');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/layout/link.jsp", out, false);
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>   \r\n");
      out.write("	");
 
		String root = request.getContextPath();
		String loginId = (String) session.getAttribute("loginId");
		
		if( loginId == null || loginId.equals("") ) {
			response.sendRedirect(root);
		}
		
		boolean login = false;
		if( loginId != null && !loginId.isEmpty() ) {
			// response.sendRedirect(root);
			login = true;
		}
		
		UserRepository userDAO = new UserRepository();
		User loginUser = userDAO.getUserById(loginId);
		
		// 이메일 : 아이디@도메인 분리
		String mail = loginUser.getMail();
		String[] temp = {"",""};
		String[] email = (mail != null && mail.length() > 0) ? mail.split("@") : temp;
		String email1 = email[0];
		String email2 = email[1];
		
		// 생일 : 연/월/일 분리
		String birthStr = loginUser.getBirth();
		String[] temp2 = {"","",""};
		String[] birth = (birthStr != null && !birthStr.isEmpty() && birthStr.contains("/") ) ? birthStr.split("/") : temp2;
		String year = "";
		String month = "";
		String day = "";
		if( birth != null && birth.length == 3 ) {
			year = birth[0];
			month = birth[1];
			day = birth[2];
		} else {
			year = "";
			month = "";
			day  = "";
		}
		
		String phone = loginUser.getPhone();
		phone =	phone == null ? "" : phone;
		loginUser.setPhone(phone);
		
		String address = loginUser.getAddress();
		address = address == null ? "" : address;
		loginUser.setAddress(address);
	
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/layout/header.jsp", out, false);
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<div class=\"row m-0 mypage\">\r\n");
      out.write("		<div class=\"sidebar border border-right col-md-3 col-lg-2 p-0 bg-body-tertiary\">\r\n");
      out.write("			<div class=\"d-flex flex-column flex-shrink-0 p-3 bg-body-tertiary\">\r\n");
      out.write("			    <ul class=\"nav nav-pills flex-column mb-auto\">\r\n");
      out.write("			      <!-- 로그인 시 -->\r\n");
      out.write("			      ");
 if( login ) { 
      out.write("\r\n");
      out.write("		    	  <li class=\"nav-item\">\r\n");
      out.write("			        <a href=\"");
      out.print( root );
      out.write("/user/index.jsp\" class=\"nav-link link-body-emphasis\">\r\n");
      out.write("			          마이 페이지\r\n");
      out.write("			        </a>\r\n");
      out.write("			      </li>\r\n");
      out.write("			      <li class=\"nav-item\">\r\n");
      out.write("			        <a href=\"");
      out.print( root );
      out.write("/user/update.jsp\" class=\"nav-link active\" aria-current=\"page\">\r\n");
      out.write("			          회원정보 수정\r\n");
      out.write("			        </a>\r\n");
      out.write("			      </li>\r\n");
      out.write("			      ");
 } 
      out.write("\r\n");
      out.write("			      <li>\r\n");
      out.write("			        <a href=\"");
      out.print( root );
      out.write("/user/order.jsp\" class=\"nav-link link-body-emphasis\">\r\n");
      out.write("			          주문내역\r\n");
      out.write("			        </a>\r\n");
      out.write("			      </li>\r\n");
      out.write("			    </ul>\r\n");
      out.write("			    <hr>\r\n");
      out.write("			  </div>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"col-md-9 ms-sm-auto col-lg-10 p-0 m-0\">\r\n");
      out.write("			<div class=\"px-4 py-3 my-3 text-center\">\r\n");
      out.write("				<h1 class=\"display-5 fw-bold text-body-emphasis\">회원 정보 수정</h1>\r\n");
      out.write("			</div>\r\n");
      out.write("			\r\n");
      out.write("			<!-- 회원 가입 영역 -->\r\n");
      out.write("			<div class=\"container shop m-auto mb-5\">\r\n");
      out.write("				<form action=\"update_pro.jsp\" name=\"updateForm\" method=\"post\" >\r\n");
      out.write("				\r\n");
      out.write("					<div class=\"input-group mb-3 row\">\r\n");
      out.write("						<label class=\"input-group-text col-md-2\" id=\"\">아이디</label>\r\n");
      out.write("						<input type=\"text\" class=\"form-control col-md-10\" \r\n");
      out.write("							   name=\"id\" placeholder=\"아이디\" required\r\n");
      out.write("							   value=\"");
      out.print( loginUser.getId() );
      out.write("\">\r\n");
      out.write("					</div>\r\n");
      out.write("					\r\n");
      out.write("					<div class=\"input-group mb-3 row\">\r\n");
      out.write("						<label class=\"input-group-text col-md-2\" id=\"\">이름</label>\r\n");
      out.write("						<input type=\"text\" class=\"form-control col-md-10\" \r\n");
      out.write("							   name=\"name\" placeholder=\"이름\" required\r\n");
      out.write("							   value=\"");
      out.print( loginUser.getName() );
      out.write("\">\r\n");
      out.write("					</div>\r\n");
      out.write("					\r\n");
      out.write("					<div class=\"input-group mb-3 row\">\r\n");
      out.write("						<div class=\"col-md-2 p-0\">\r\n");
      out.write("							<label class=\"input-group-text\" id=\"\">성별</label>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"col-md-10 d-flex align-items-center\">\r\n");
      out.write("							<input type=\"hidden\" name=\"temp-gender\" value=\"");
      out.print( loginUser.getGender() );
      out.write("\"\r\n");
      out.write("								   id=\"temp-gender\" />\r\n");
      out.write("							<div class=\"radio-box d-flex\">\r\n");
      out.write("								<div class=\"radio-item mx-5\">\r\n");
      out.write("									<input type=\"radio\" class=\"form-check-input\" name=\"gender\" value=\"여\" id=\"gender-female\"> \r\n");
      out.write("									<label for=\"gender-female\">여자</label>\r\n");
      out.write("								</div>\r\n");
      out.write("								\r\n");
      out.write("								<div class=\"radio-item mx-5\">\r\n");
      out.write("									<input type=\"radio\" class=\"form-check-input \" name=\"gender\" value=\"남\" id=\"gender-male\"> \r\n");
      out.write("									<label for=\"gender-male\">남자</label>\r\n");
      out.write("								</div>\r\n");
      out.write("								\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("					\r\n");
      out.write("					\r\n");
      out.write("					<div class=\"input-group mb-3 row\">\r\n");
      out.write("						<div class=\"col-md-2 p-0\">\r\n");
      out.write("							<label class=\"input-group-text\" id=\"\">생일</label>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"col-md-10 d-flex align-items-center\">\r\n");
      out.write("							<div class=\"row\">\r\n");
      out.write("								<div class=\"col\">\r\n");
      out.write("									<input type=\"text\" class=\"form-control\" name=\"year\" placeholder=\"출생년도 \" size=\"6\" \r\n");
      out.write("										   value=\"");
      out.print( year );
      out.write("\">\r\n");
      out.write("								</div>\r\n");
      out.write("								\r\n");
      out.write("								<div class=\"col\">\r\n");
      out.write("									<input type=\"hidden\" name=\"tempMonth\" value=\"");
      out.print( month );
      out.write("\" id=\"temp-month\">\r\n");
      out.write("									<select name=\"month\" class=\"h-100 form-select\" >\r\n");
      out.write("										<option value=\"01\">1월</option>\r\n");
      out.write("										<option value=\"02\">2월</option>\r\n");
      out.write("										<option value=\"03\">3월</option>\r\n");
      out.write("										<option value=\"04\">4월</option>\r\n");
      out.write("										<option value=\"05\">5월</option>\r\n");
      out.write("										<option value=\"06\">6월</option>\r\n");
      out.write("										<option value=\"07\">7월</option>\r\n");
      out.write("										<option value=\"08\">8월</option>\r\n");
      out.write("										<option value=\"09\">9월</option>\r\n");
      out.write("										<option value=\"10\">10월</option>\r\n");
      out.write("										<option value=\"11\">11월</option>\r\n");
      out.write("										<option value=\"12\">12월</option>\r\n");
      out.write("									</select>\r\n");
      out.write("								</div>\r\n");
      out.write("								\r\n");
      out.write("								<div class=\"col\">\r\n");
      out.write("									<input type=\"text\" class=\"form-control\" name=\"day\" placeholder=\"일자\" size=\"4\" \r\n");
      out.write("										   value=\"");
      out.print( day );
      out.write("\">\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("					\r\n");
      out.write("					<div class=\"input-group mb-3 row\">\r\n");
      out.write("						<label class=\"input-group-text col-md-2\" id=\"\">이메일</label>\r\n");
      out.write("						\r\n");
      out.write("						<div class=\"row col-md-10 align-items-center\">\r\n");
      out.write("							<div class=\"col-4 px-0\">\r\n");
      out.write("								<input type=\"text\" class=\"form-control col-md-10\" \r\n");
      out.write("									   name=\"email1\" placeholder=\"이메일\"\r\n");
      out.write("									   value=\"");
      out.print( email1 );
      out.write("\">\r\n");
      out.write("							</div>\r\n");
      out.write("							<div class=\"col-auto\">\r\n");
      out.write("								@\r\n");
      out.write("							</div>\r\n");
      out.write("							<div class=\"col-4 px-0\">\r\n");
      out.write("								<input type=\"hidden\" name=\"tempEmail2\" value=\"");
      out.print( email2 );
      out.write("\" id=\"temp-email2\">\r\n");
      out.write("								<select name=\"email2\" class=\"form-select\">\r\n");
      out.write("									<option value=\"naver.com\">naver.com</option>\r\n");
      out.write("									<option value=\"gmail.com\">gmail.com</option>\r\n");
      out.write("									<option value=\"kakao.com\">kakao.com</option>\r\n");
      out.write("								</select>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("					\r\n");
      out.write("					<div class=\"input-group mb-3 row\">\r\n");
      out.write("						<label class=\"input-group-text col-md-2\" id=\"\">전화번호</label>\r\n");
      out.write("						<input type=\"text\" class=\"form-control col-md-10\" \r\n");
      out.write("							   name=\"phone\" placeholder=\"전화번호\"\r\n");
      out.write("							   value=\"");
      out.print( loginUser.getPhone() );
      out.write("\">\r\n");
      out.write("					</div>\r\n");
      out.write("					\r\n");
      out.write("					<div class=\"input-group mb-3 row\">\r\n");
      out.write("						<label class=\"input-group-text col-md-2\" id=\"\">주소</label>\r\n");
      out.write("						<input type=\"text\" class=\"form-control col-md-10\" \r\n");
      out.write("							   name=\"address\" placeholder=\"주소\"\r\n");
      out.write("							   value=\"");
      out.print( loginUser.getAddress() );
      out.write("\">\r\n");
      out.write("					</div>\r\n");
      out.write("					\r\n");
      out.write("					\r\n");
      out.write("					<div class=\"d-flex justify-content-between mt-5 mb-5\">\r\n");
      out.write("						<a href=\"javascript: ;\" onclick=\"alertDel()\" class=\"btn btn-lg btn-danger\" >탈퇴</a>\r\n");
      out.write("						<input type=\"submit\" class=\"btn btn-lg btn-primary\" value=\"수정\" />\r\n");
      out.write("					</div>	\r\n");
      out.write("					\r\n");
      out.write("					\r\n");
      out.write("				</form>\r\n");
      out.write("			\r\n");
      out.write("			</div>\r\n");
      out.write("			\r\n");
      out.write("			");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/layout/footer.jsp", out, false);
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/layout/script.jsp", out, false);
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("	<script>\r\n");
      out.write("		\r\n");
      out.write("		let form = document.updateForm\r\n");
      out.write("		\r\n");
      out.write("		// 성별 선택\r\n");
      out.write("		let tempGender = document.getElementById('temp-gender')\r\n");
      out.write("		let radioFemale = document.getElementById('gender-female')\r\n");
      out.write("		let radioMale = document.getElementById('gender-male')\r\n");
      out.write("		// alert(tempGender.value)\r\n");
      out.write("		if( tempGender.value == '남' )		radioMale.checked = true\r\n");
      out.write("		if( tempGender.value == '여' )		radioFemale.checked = true\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		// 생일 월 (select) 선택\r\n");
      out.write("		let tempMonth = document.getElementById('temp-month')\r\n");
      out.write("		let selectMonth = form.month\r\n");
      out.write("		selectMonth.value = tempMonth.value\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		// 메일 도메인 (select) 선택\r\n");
      out.write("		let tempEmail2 = document.getElementById('temp-email2')\r\n");
      out.write("		let selectEmail2 = form.email2\r\n");
      out.write("		selectEmail2.value = tempEmail2.value\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		// 탈퇴 체크\r\n");
      out.write("		function alertDel() {\r\n");
      out.write("\r\n");
      out.write("			let form = document.updateForm\r\n");
      out.write("\r\n");
      out.write("			let check = confirm('정말 탈퇴하시겠습니까?')\r\n");
      out.write("\r\n");
      out.write("			if( check ) {\r\n");
      out.write("				form.action = 'delete.jsp'\r\n");
      out.write("				form.submit()\r\n");
      out.write("			}\r\n");
      out.write("\r\n");
      out.write("		}\r\n");
      out.write("	\r\n");
      out.write("	</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
