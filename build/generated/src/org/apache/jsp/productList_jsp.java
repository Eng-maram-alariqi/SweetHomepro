package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.URLDecoder;

public final class productList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Home Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("            <nav class=\"navbar navbar-light bg-light\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <button class=\"btn btn-outline-success me-2\" onclick=\"openFilterModal()\" type=\"button\">Filter</button>\n");
      out.write("                    <form class=\"d-flex\">\n");
      out.write("                        <input class=\"form-control me-2\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\">\n");
      out.write("                        <button class=\"btn btn-outline-success\" type=\"submit\">Search</button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row row-cols-1 row-cols-md-4 g-4\">\n");
      out.write("                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            </div>        \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "products/product_details_modal.jsp", out, false);
      out.write("\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "products/filter_modal.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/footer.jsp", out, false);
      out.write("\n");
      out.write("        <script>\n");
      out.write("            // JavaScript to open the modal and set content\n");
      out.write("            function openCardModal(title, images, details) {\n");
      out.write("                var modal = $('#productDetailsModal');\n");
      out.write("\n");
      out.write("                // Set the modal title\n");
      out.write("                modal.find('.modal-title').text(title);\n");
      out.write("\n");
      out.write("                // Create carousel indicators and images\n");
      out.write("                var carouselIndicators = modal.find('#carouselIndicators');\n");
      out.write("                var carouselImages = modal.find('#carouselImages');\n");
      out.write("                carouselIndicators.empty();\n");
      out.write("                carouselImages.empty();\n");
      out.write("\n");
      out.write("                for (var i = 0; i < images.length; i++) {\n");
      out.write("                    var activeClass = i === 0 ? 'active' : '';\n");
      out.write("                    carouselIndicators.append('<button type=\"button\" data-bs-target=\"#carouselExampleIndicators\" data-bs-slide-to=\"' + i + '\" class=\"' + activeClass + '\" aria-label=\"Slide ' + (i + 1) + '\"></button>');\n");
      out.write("                    carouselImages.append('<div class=\"carousel-item ' + activeClass + '\"><img src=\"' + images[i] + '\" class=\"d-block w-100\" alt=\"...\"></div>');\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                // Set the modal details\n");
      out.write("                modal.find('#modalDetails').text(details);\n");
      out.write("\n");
      out.write("                // Show the modal\n");
      out.write("                modal.modal('show');\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            function openFilterModal() {\n");
      out.write("                var modal = $('#filterModal');          \n");
      out.write("                // Show the modal\n");
      out.write("                modal.modal('show');\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
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
          out.write("\n");
          out.write("                <div class=\"col\">\n");
          out.write("                    <div class=\"card\" onclick=\"openCardModal('Build your dream home', [\n");
          out.write("                                'https://photos.zillowstatic.com/fp/cb1d9b4cfe1258bcc239b04306afd872-cc_ft_1536.webp',\n");
          out.write("                                'https://photos.zillowstatic.com/fp/6b1853873c2703b1d5e00c92c5bdc1eb-cc_ft_384.webp',\n");
          out.write("                                'https://photos.zillowstatic.com/fp/0dc7ceff5f6c132f3d3f1acc5922e950-cc_ft_384.webp',\n");
          out.write("                            ], 'Build your dream home, or invest in your future, on this beautiful .23 acre lot in Lehigh Acres community. This lot is located just minutes drive from Walmart, and downtown Lehigh Acres. Elementary and Middle school just 5 min drive and Lehigh Senior High school just 3 mins away. Enjoy the stunning Florida Sunsets on this oversized lot. This lot is also just a short car ride to both the Boston Redsox & Minnesota Twins spring training facilities, International airport, Downtown & Central Fort Myers, Fort Myers Beaches, Sanibel/Captiva Islands, Miromar Outlets, Gulf Coast Town Center, Labelle, and Pine Island/ Matalacha area. Location, Location and best price on market!')\">\n");
          out.write("                        <img src=\"https://photos.zillowstatic.com/fp/cb1d9b4cfe1258bcc239b04306afd872-cc_ft_1536.webp\" class=\"card-img-top\" alt=\"...\" height=\"200\">\n");
          out.write("                        <div class=\"card-body\">\n");
          out.write("                            <h5 class=\"card-title max-lines-1\">Build your dream home</h5>\n");
          out.write("                            <p class=\"card-text max-lines-2\">Build your dream home, or invest in your future, on this beautiful .23 acre lot in Lehigh Acres community. This lot is located just minutes drive from Walmart, and downtown Lehigh Acres. Elementary and Middle school just 5 min drive and Lehigh Senior High school just 3 mins away. Enjoy the stunning Florida Sunsets on this oversized lot. This lot is also just a short car ride to both the Boston Redsox & Minnesota Twins spring training facilities, International airport, Downtown & Central Fort Myers, Fort Myers Beaches, Sanibel/Captiva Islands, Miromar Outlets, Gulf Coast Town Center, Labelle, and Pine Island/ Matalacha area. Location, Location and best price on market!</p>\n");
          out.write("                        </div>\n");
          out.write("                    </div>\n");
          out.write("                </div>\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
