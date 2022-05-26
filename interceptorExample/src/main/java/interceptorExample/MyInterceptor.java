package interceptorExample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInterceptor  extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("This is prehandler , and return true if want to continue");
		
		//return super.preHandle(request, response, handler);

		// to apply validation on nam ecoming form the form
		
		String name=request.getParameter("user");
		if(name.startsWith("d"))
		{
			response.setContentType("text/html");
			response.getWriter().println("<h1>Invalid NAme: Name should not Start with d</h1>");
			return false; //return no need to accept the d strings
			
		}
		
		return true;
	
	}
	

	//smple override the other methods
	

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("This is post Hanler mthrod.. before veiw");
		
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
	System.out.println("This is after completion method.. After view ");
		super.afterCompletion(request, response, handler, ex);
	}

	//if we had taken the interface then we need to override all method , so chosen it implemented class to be flexible to override only requeired method by us.
	
	
	
}
