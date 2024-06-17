/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.100
 * Generated at: 2024-04-30 03:50:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import shop.dto.User;
import shop.dao.UserRepository;
import java.util.List;
import shop.dto.Order;
import shop.dao.OrderRepository;
import shop.dto.Product;

public final class order_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = new java.util.LinkedHashSet<>(6);
    _jspx_imports_classes.add("shop.dto.Product");
    _jspx_imports_classes.add("shop.dao.OrderRepository");
    _jspx_imports_classes.add("shop.dto.User");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("shop.dao.UserRepository");
    _jspx_imports_classes.add("shop.dto.Order");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Shop</title>\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/layout/meta.jsp", out, false);
      out.write(" \r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/layout/link.jsp", out, false);
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>   \r\n");
      out.write("    ");

        String root = request.getContextPath();
        String loginId = (String) session.getAttribute("loginId");
        boolean login = loginId != null && !loginId.isEmpty();
        UserRepository userDAO = new UserRepository();
        User loginUser = userDAO.getUserById(loginId);
    
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/layout/header.jsp", out, false);
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    <div class=\"row m-0 mypage\">\r\n");
      out.write("        <div class=\"sidebar border border-right col-md-3 col-lg-2 p-0 bg-body-tertiary\">\r\n");
      out.write("            <div class=\"d-flex flex-column flex-shrink-0 p-3 bg-body-tertiary\">\r\n");
      out.write("                <ul class=\"nav nav-pills flex-column mb-auto\">\r\n");
      out.write("                    ");
 if (login) { 
      out.write("\r\n");
      out.write("                        <li class=\"nav-item\">\r\n");
      out.write("                            <a href=\"");
      out.print( root );
      out.write("/user/index.jsp\" class=\"nav-link link-body-emphasis\">\r\n");
      out.write("                                마이 페이지\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"nav-item\">\r\n");
      out.write("                            <a href=\"");
      out.print( root );
      out.write("/user/update.jsp\" class=\"nav-link link-body-emphasis\">\r\n");
      out.write("                                회원정보 수정\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    ");
 } 
      out.write("\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#\" class=\"nav-link active\" aria-current=\"page\" >\r\n");
      out.write("                            주문내역\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <hr>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"col-md-9 ms-sm-auto col-lg-10 p-0 m-0\">\r\n");
      out.write("            <div class=\"px-4 py-3 my-3 text-center\">\r\n");
      out.write("                <h1 class=\"display-5 fw-bold text-body-emphasis\">주문 내역</h1>\r\n");
      out.write("                <div class=\"col-lg-6 mx-auto\">\r\n");
      out.write("                    ");
 if (!login) { 
      out.write("    \r\n");
      out.write("                        <p class=\"lead mb-4\">비회원 주문하신 경우, 전화번호와 주문 비밀번호를 입력해주세요.</p>\r\n");
      out.write("                    ");
 } 
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"container shop m-auto mb-5\">\r\n");
      out.write("                <form action=\"");
      out.print( root );
      out.write("/user/order_pro.jsp\" method=\"post\">\r\n");
      out.write("                    ");
 if (!login) { 
      out.write("\r\n");
      out.write("                        <div class=\"mb-5\">\r\n");
      out.write("                            <table class=\"table\">\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>전화번호 :</td>\r\n");
      out.write("                                    <td>\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" name=\"phone\" placeholder=\"- 생략하고 숫자만 입력해주세요.\">\r\n");
      out.write("                                    </td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>주문 비밀번호 :</td>\r\n");
      out.write("                                    <td>\r\n");
      out.write("                                        <input type=\"password\" class=\"form-control\" name=\"orderPw\" placeholder=\"주문 비밀번호를 입력해주세요.\">\r\n");
      out.write("                                    </td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                            </table>\r\n");
      out.write("                            <div class=\"btn-box d-grid gap-2\">\r\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-outline-primary btn-lg px-4 gap-3\">조회</button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    ");
 } 
      out.write("\r\n");
      out.write("                </form>\r\n");
      out.write("                ");
 
                    String orderPhone = (String) session.getAttribute("orderPhone");
                    String orderPw = (String) session.getAttribute("orderPw");
                
      out.write("\r\n");
      out.write("                ");
 if (login || (orderPhone != null && !orderPhone.isEmpty())) { 
      out.write("\r\n");
      out.write("                    <table class=\"table table-striped table-hover table-bordered text-center align-middle\">\r\n");
      out.write("                        <thead>\r\n");
      out.write("                            <tr class=\"table-primary\">\r\n");
      out.write("                                <th>주문번호</th>\r\n");
      out.write("                                <th>상품</th>\r\n");
      out.write("                                <th>가격</th>\r\n");
      out.write("                                <th>수량</th>\r\n");
      out.write("                                <th>소계</th>\r\n");
      out.write("                                <th>비고</th>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                        </thead>\r\n");
      out.write("                        <tbody>\r\n");
      out.write("                            ");
  
                                OrderRepository orderDao = new OrderRepository();
                                List<Product> orderList = login ? orderDao.list(loginId) : orderDao.list(orderPhone, orderPw);
                                int sum = 0;
                                for (Product product : orderList) {
                                    int total = product.getUnitPrice() * product.getQuantity();
                                    sum += total;
                            
      out.write("\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>");
      out.print( product.getOrderNo() );
      out.write("</td>         \r\n");
      out.write("                                <td>");
      out.print( product.getName() );
      out.write("</td>         \r\n");
      out.write("                                <td>");
      out.print( product.getUnitPrice() );
      out.write("</td>         \r\n");
      out.write("                                <td>");
      out.print( product.getQuantity() );
      out.write("</td>         \r\n");
      out.write("                                <td>");
      out.print( total );
      out.write("</td>         \r\n");
      out.write("                                <td></td>         \r\n");
      out.write("                            </tr>\r\n");
      out.write("                            ");
 } 
      out.write("\r\n");
      out.write("                        </tbody>\r\n");
      out.write("                        <tfoot>\r\n");
      out.write("                            ");
 if (orderList.isEmpty()) { 
      out.write("\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td colspan=\"6\">추가된 상품이 없습니다.</td>    \r\n");
      out.write("                                </tr>\r\n");
      out.write("                            ");
 } else { 
      out.write("\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td></td>\r\n");
      out.write("                                    <td></td>\r\n");
      out.write("                                    <td>총액</td>\r\n");
      out.write("                                    <td id=\"cart-sum\">");
      out.print( sum );
      out.write("</td>\r\n");
      out.write("                                    <td></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                            ");
 } 
      out.write("\r\n");
      out.write("                        </tfoot>\r\n");
      out.write("                    </table>\r\n");
      out.write("                ");
 } 
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/layout/footer.jsp", out, false);
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/layout/script.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
