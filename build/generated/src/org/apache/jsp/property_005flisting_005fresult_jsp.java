package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.URLDecoder;

public final class property_005flisting_005fresult_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

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
      out.write("    <title>Property Listings</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/property_listing_result.css\">\r\n");
      out.write("    \r\n");
      out.write("    <!-- Add Bootstrap CSS -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container mt-4\">\r\n");
      out.write("        \r\n");
      out.write("        <h1 class=\"text-center\">Property Listings</h1>\r\n");
      out.write("        <form action=\"propertyListing.jsp\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("       \r\n");
      out.write("            <button class=\"btn btn-info\">Insert</button>\r\n");
      out.write("        </form>\r\n");
      out.write("        <table class=\"table table-striped\">\r\n");
      out.write("            <thead>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th>ID</th>\r\n");
      out.write("                    <th>City</th>\r\n");
      out.write("                    <th>Location</th>\r\n");
      out.write("                    <th>Price</th>\r\n");
      out.write("                    <th>Bedrooms</th>\r\n");
      out.write("                    <th>Bathrooms</th>\r\n");
      out.write("                    <th>Property Type</th>\r\n");
      out.write("                    <th>Extra Facilities</th>\r\n");
      out.write("                    <th>Transport Modes</th>\r\n");
      out.write("                    <th>Furniture</th>\r\n");
      out.write("                    <th>Images</th>\r\n");
      out.write("                    <th>Payment Mode</th>\r\n");
      out.write("                    <th>Contact Details</th>\r\n");
      out.write("                    <th>Transaction Type</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            <tbody>\r\n");
      out.write("                ");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
      _jspx_th_c_forEach_0.setParent(null);
      _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${propertyListings}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
      _jspx_th_c_forEach_0.setVar("property");
      int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
      try {
        int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
        if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                    <tr>\r\n");
            out.write("                        <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.propertyId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                        <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.city}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                        <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.location}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                        <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                        <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.bedrooms}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                        <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.bathrooms}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                        <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.propertyType}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                        <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.extraFacilities}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                        <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.transportModes}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                        <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.furniture}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                        <td>\r\n");
            out.write("                            <a href=\"images.jsp?imagePaths=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.imagePaths}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\">\r\n");
            out.write("                                <button class=\"btn btn-primary\">View images</button>\r\n");
            out.write("                            </a>\r\n");
            out.write("                        </td>\r\n");
            out.write("                        <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.paymentMode}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                        <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.contactDetails}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                        <td>\r\n");
            out.write("                            \r\n");
            out.write("                            \r\n");
            out.write("                            <!-- Update Button -->\r\n");
            out.write("                            <form action=\"update_property.jsp\" method=\"get\" enctype=\"multipart/form-data\">\r\n");
            out.write("                                                            <div class=\"button-container\" style=\"display: none; visibility: hidden;\">\r\n");
            out.write("\r\n");
            out.write("                                <input type=\"hidden\"  name=\"propertyId\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.propertyId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\">\r\n");
            out.write("            <input type=\"hidden\"  name=\"city\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.city}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\">\r\n");
            out.write("            <input type=\"hidden\" name=\"location\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.location}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\">\r\n");
            out.write("              <input type=\"hidden\" name=\"price\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\"><br>\r\n");
            out.write("              <input type=\"hidden\" name=\"bedrooms\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.bedrooms}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\">\r\n");
            out.write("               <input type=\"hidden\" name=\"bathrooms\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.bathrooms}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\">\r\n");
            out.write("                       <input type=\"hidden\" name=\"propertyType\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.propertyType}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\">\r\n");
            out.write("\r\n");
            out.write("               <input type=\"hidden\" name=\"extraFacilities\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.extraFacilities}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\">\r\n");
            out.write("               \r\n");
            out.write("       \r\n");
            out.write("\r\n");
            out.write("<select name=\"transportModes\" required>\r\n");
            out.write("    <option value=\"Residential Land\" ");
            out.print( "Residential Land".equals(request.getParameter("transportModes")) ? "selected" : "" );
            out.write(">Residential Land</option>\r\n");
            out.write("    <option value=\"Commercial\" ");
            out.print( "Commercial".equals(request.getParameter("transportModes")) ? "selected" : "" );
            out.write(">Commercial</option>\r\n");
            out.write("    <option value=\"Condominium\" ");
            out.print( "Condominium".equals(request.getParameter("transportModes")) ? "selected" : "" );
            out.write(">Condominium</option>\r\n");
            out.write("    <option value=\"Townhouse\" ");
            out.print( "Townhouse".equals(request.getParameter("transportModes")) ? "selected" : "" );
            out.write(">Townhouse</option>\r\n");
            out.write("    <option value=\"Multi-unit dwelling\" ");
            out.print( "Multi-unit dwelling".equals(request.getParameter("transportModes")) ? "selected" : "" );
            out.write(">Multi-unit dwelling</option>\r\n");
            out.write("</select><br>\r\n");
            out.write("\r\n");
            out.write("        \r\n");
            out.write("           <input type=\"hidden\" name=\"furniture\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.furniture}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\">\r\n");
            out.write("           \r\n");
            out.write("           <input type=\"hidden\" name=\"image\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.imagePaths}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\">\r\n");
            out.write("             \r\n");
            out.write("             <input type=\"hidden\" name=\"paymentMode\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.paymentMode}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\">\r\n");
            out.write("                          <input type=\"hidden\" name=\"contactDetails\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.contactDetails}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\">\r\n");
            out.write("      </div>\r\n");
            out.write("                                <!-- Add other hidden fields as needed -->\r\n");
            out.write("                                <button class=\"btn btn-success\">Update</button>\r\n");
            out.write("                            </form>\r\n");
            out.write("                            <!-- Delete Button -->\r\n");
            out.write("                            <form id=\"deleteForm\" action=\"PropertyListingsServlet\" method=\"get\" enctype=\"multipart/form-data\" onsubmit=\"return confirmDelete()\">\r\n");
            out.write("                                <input type=\"hidden\" name=\"action\" value=\"delete\">\r\n");
            out.write("                                <input type=\"hidden\" name=\"propertyId\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${property.propertyId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\">\r\n");
            out.write("                                <button class=\"btn btn-danger\">Delete</button>\r\n");
            out.write("                            </form>\r\n");
            out.write("                          \r\n");
            out.write("                        </td>\r\n");
            out.write("                    </tr>\r\n");
            out.write("                ");
            int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_forEach_0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_forEach_0.doFinally();
        _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
      }
      out.write("\r\n");
      out.write("            </tbody>\r\n");
      out.write("        </table>\r\n");
      out.write("        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Add Bootstrap JS -->\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    String message = (String) request.getSession().getAttribute("message");
    if (message != null) {

      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        Swal.fire({\r\n");
      out.write("            title: 'Success',\r\n");
      out.write("            text: '");
      out.print( message );
      out.write("',\r\n");
      out.write("            icon: 'success'\r\n");
      out.write("        });\r\n");
      out.write("    </script>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    ");
 request.getSession().removeAttribute("message"); 
      out.write('\r');
      out.write('\n');

    }

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    function confirmDelete() {\r\n");
      out.write("        Swal.fire({\r\n");
      out.write("            title: 'Are you sure?',\r\n");
      out.write("            text: 'Delete this property listing.',\r\n");
      out.write("            icon: 'warning',\r\n");
      out.write("            showCancelButton: true,\r\n");
      out.write("            confirmButtonColor: '#3085d6',\r\n");
      out.write("            cancelButtonColor: '#d33',\r\n");
      out.write("            confirmButtonText: 'Yes, delete it!'\r\n");
      out.write("        }).then((result) => {\r\n");
      out.write("            if (result.isConfirmed) {\r\n");
      out.write("                // Submit the \"Delete\" form\r\n");
      out.write("                document.getElementById('deleteForm').submit();\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        // Prevent the form from submitting immediately\r\n");
      out.write("        return false;\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empty propertyListings}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("            <p>No property listings found.</p>\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }
}
