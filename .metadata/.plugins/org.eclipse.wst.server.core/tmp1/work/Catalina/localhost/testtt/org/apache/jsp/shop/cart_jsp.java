/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.100
 * Generated at: 2024-04-30 03:50:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.shop;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import shop.dto.Product;
import java.util.List;
import shop.dao.ProductRepository;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = new java.util.LinkedHashSet<>(4);
    _jspx_imports_classes.add("shop.dto.Product");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("shop.dao.ProductRepository");
    _jspx_imports_classes.add("java.util.ArrayList");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>장바구니</title>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/layout/meta.jsp", out, false);
      out.write(' ');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/layout/link.jsp", out, false);
      out.write("\r\n");
      out.write("</head>\r\n");

    String root = request.getContextPath(); 
    String productId = request.getParameter("productId");
    
    if (productId != null) {
        ProductRepository productDao = new ProductRepository();
        Product product = productDao.getProductById(productId);
        
        if (product != null) {
            List<Product> cartList = (List<Product>) session.getAttribute("cartList");
            
            if (cartList == null) {
                cartList = new ArrayList<>();
                session.setAttribute("cartList", cartList);
            }
            
            boolean duplicate = false;
            for (Product item : cartList) {
                if (item.getProductId().equals(productId)) {
                    duplicate = true;
                    item.setQuantity(item.getQuantity() + 1);
                    break;
                }
            }
            
            if (!duplicate) {
                product.setQuantity(1);
                cartList.add(product);
            }
            
            response.sendRedirect("products.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

      out.write("\r\n");
      out.write("<body>   \r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/layout/header.jsp", out, false);
      out.write("\r\n");
      out.write("    <div class=\"px-4 py-5 my-5 text-center\">\r\n");
      out.write("        <h1 class=\"display-5 fw-bold text-body-emphasis\">장바구니</h1>\r\n");
      out.write("        <div class=\"col-lg-6 mx-auto\">\r\n");
      out.write("            <p class=\"lead mb-4\">장바구니 목록 입니다.</p>\r\n");
      out.write("            <div class=\"container mt-5\">\r\n");
      out.write("                <table class=\"table table-striped table-hover table-bordered text-center align-middle\">\r\n");
      out.write("                    <thead class=\"table-primary\">\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th>상품</th>\r\n");
      out.write("                            <th>가격</th>\r\n");
      out.write("                            <th>수량</th>\r\n");
      out.write("                            <th>소계</th>\r\n");
      out.write("                            <th>비고</th>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </thead>\r\n");
      out.write("                    <tbody>\r\n");
      out.write("                        ");
 
                        List<Product> cartList = (List<Product>) session.getAttribute("cartList");
                        if (cartList != null && !cartList.isEmpty()) {
                            int sum = 0;
                            for (Product product : cartList) {
                                int unitPrice = product.getUnitPrice() == null ? 0 : product.getUnitPrice();
                                int total = unitPrice * product.getQuantity();
                                sum += total;
                        
      out.write("\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>");
      out.print( product.getName() );
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print( product.getUnitPrice() );
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print( product.getQuantity() );
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print( total );
      out.write("</td>\r\n");
      out.write("                            <td>\r\n");
      out.write("                                <form action=\"");
      out.print( root );
      out.write("/shop/deleteCart.jsp\" method=\"post\">\r\n");
      out.write("                                    <input type=\"hidden\" name=\"productId\" value=\"");
      out.print( product.getProductId() );
      out.write("\" />\r\n");
      out.write("                                    <button type=\"submit\" class=\"btn btn-danger\">삭제</button>\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        ");
 }
                        
      out.write("\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td colspan=\"3\">총액</td>\r\n");
      out.write("                            <td>");
      out.print( sum );
      out.write("</td>\r\n");
      out.write("                            <td></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        ");
 } else { 
      out.write("\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td colspan=\"5\">장바구니에 담긴 상품이 없습니다.</td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        ");
 } 
      out.write("\r\n");
      out.write("                    </tbody>\r\n");
      out.write("                </table>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"row justify-content-between\">\r\n");
      out.write("                <div class=\"col-auto\">\r\n");
      out.write("                    <a href=\"");
      out.print( root );
      out.write("/shop/deleteCart.jsp\" class=\"btn btn-danger btn-lg\">전체삭제</a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-auto\">\r\n");
      out.write("                    <form action=\"");
      out.print( root );
      out.write("/shop/ship.jsp\" onsubmit=\"return checkCart()\" method=\"post\">\r\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-primary btn-lg\">주문하기</button>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <script>\r\n");
      out.write("        function checkCart() {\r\n");
      out.write("            var isCartEmpty = ");
      out.print( cartList == null || cartList.isEmpty() );
      out.write(";\r\n");
      out.write("            if (isCartEmpty) {\r\n");
      out.write("                alert('장바구니에 담긴 상품이 없습니다.');\r\n");
      out.write("                return false;\r\n");
      out.write("            }\r\n");
      out.write("            return true;\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/layout/footer.jsp", out, false);
      out.write("\r\n");
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
