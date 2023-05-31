package ex16;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Simpletag extends SimpleTagSupport{

	@Override
	 public void doTag() throws JspException,IOException {
		PageContext pageContext = (PageContext)getJspContext();
		JspWriter out = pageContext.getOut();
		for(var i=0; i<5; i++) {
			out.println("Hello");
		}
	}


	

}
// 태그 만드는 곳