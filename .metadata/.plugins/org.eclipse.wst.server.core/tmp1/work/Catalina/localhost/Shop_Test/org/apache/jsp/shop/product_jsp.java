/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.100
 * Generated at: 2024-04-30 01:17:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.shop;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import shop.dao.ProductRepository;
import java.util.List;
import shop.dto.Product;

public final class product_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1714364338150L));
    _jspx_dependants.put("jar:file:/D:/BYJ/JSP/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/Shop_Test/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
  }

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
      out.write("\r\n");
      out.write("     \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("	<meta charset=\"UTF-8\">\r\n");
      out.write("	<title>Products</title>\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/layout/meta.jsp", out, false);
      out.write('\r');
      out.write('\n');
      out.write('	');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/layout/link.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
 
	String root = request.getContextPath(); 
	String productId = request.getParameter("productId");
	ProductRepository productDao = new ProductRepository();
	Product product = productDao.getProductById(productId);
	

      out.write("\r\n");
      out.write("<body>   \r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/layout/header.jsp", out, false);
      out.write("\r\n");
      out.write("    <div class=\"px-4 py-5 my-5 text-center\">\r\n");
      out.write("        <h1 class=\"display-5 fw-bold text-body-emphasis\">상품 정보</h1>\r\n");
      out.write("        <div class=\"col-lg-6 mx-auto\">\r\n");
      out.write("            <p class=\"lead mb-4\">Shop 쇼핑몰 입니다.</p>\r\n");
      out.write("            <div class=\"d-grid gap-2 d-lg-flex justify-content-sm-center\">\r\n");
      out.write("                <a href=\"");
      out.print( root );
      out.write("/shop/products.jsp\" class=\"btn btn-primary btn-lg px-3 gap-2\">상품 목록</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"container mt-5\">\r\n");
      out.write("			    <div class=\"row\">\r\n");
      out.write("			        <div class=\"col-md-6\">\r\n");
      out.write("			            <img class=\"card-img-top\" src=\"");
      out.print( root );
      out.print( product.getFile() );
      out.write("\" alt=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" style=\"width:100%; max-width: 300px;\">\r\n");
      out.write("			        </div>\r\n");
      out.write("			        <div class=\"col-md-6\">\r\n");
      out.write("			            <h5 class=\"card-title\" style=\"font-weight: bold;\"> ");
      out.print( product.getName() );
      out.write("</h5> <br>\r\n");
      out.write("			            <p class=\"card-text text-start\"> 상품 ID : &nbsp;&nbsp;&nbsp;&nbsp; ");
      out.print( product.getProductId() );
      out.write("</p> <hr>\r\n");
      out.write("			            <p class=\"card-text text-start\">  제조사 : &nbsp;&nbsp;&nbsp;&nbsp; ");
      out.print( product.getManufacturer() );
      out.write(" </p> <hr>\r\n");
      out.write("			            <p class=\"card-text text-start\">  분류 :  &nbsp;&nbsp;&nbsp;&nbsp; ");
      out.print( product.getCategory() );
      out.write(" </p> <hr>\r\n");
      out.write("			            <p class=\"card-text text-start\">  상태 :  &nbsp;&nbsp;&nbsp;&nbsp; ");
      out.print( product.getCondition() );
      out.write(" </p> <hr>\r\n");
      out.write("			            <p class=\"card-text text-start\"> 재고수 : &nbsp;&nbsp;&nbsp;&nbsp; ");
      out.print( product.getUnitsInStock() );
      out.write(" </p> <hr>\r\n");
      out.write("			            <p class=\"card-text text-start\">  가격 :  &nbsp;&nbsp;&nbsp;&nbsp; ");
      out.print( product.getUnitPrice() );
      out.write(" </p> <hr>\r\n");
      out.write("			        </div>\r\n");
      out.write("			    </div>\r\n");
      out.write("			    <div class=\"d-grid gap-4 d-sm-flex justify-content-sm-end\">\r\n");
      out.write("					<a href=\"");
      out.print( root );
      out.write("/shop/cart.jsp\" class=\"btn btn-warning btn-lg px-3 gap-2\">장바구니</a>\r\n");
      out.write("					<a href=\"");
      out.print( root );
      out.write("/shop/cart_pro.jsp?productId=");
      out.print( productId );
      out.write("\" class=\"btn btn-success btn-lg px-3 gap-2\">주문하기</a>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/layout/footer.jsp", out, false);
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/layout/script.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
