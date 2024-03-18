package com.javaee.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class FirstFilter implements Filter{

	//���ٷ���
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.err.println("FirstFilter destroy....");
	}

	//FilterChain��������������һ��������һ����������������������web.xml���õ�˳�򣬽���������װΪ��������
	//ִ��doFilter����������request��response������ô��ǰ������ִ����ɣ�������һ�����������ϵ���������������
	//�������󲻻�����ִ��
	//��дdoFilter�������˷���Ϊ���ط���
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("First��������ǰ�ò���....");
		//����1�����ʱ��request������û��name������
		System.out.println(request.getAttribute("name"));
		//����������
		chain.doFilter(request, response);
		//��dofilter����֮�����ǿ����ٴζ�request��response������д���
//		��ʱ�����Ѿ�������Servlet�Ĵ�������ȡ����JstlServlet���а󶨵�name����
		System.out.println(request.getAttribute("name"));
		System.out.println("First����������ò���....");
	}

	//�˷���Ϊ��ʼ������
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.err.println("FirstFilter init....");
	}

}
