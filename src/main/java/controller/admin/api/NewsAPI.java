package controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.NewsModel;
import service.INewsService;
import utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-news" })
public class NewsAPI extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private INewsService newsService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();

		req.setCharacterEncoding("UTF-8");

		resp.setContentType("application/json");

		NewsModel newsModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class);

		newsModel = newsService.save(newsModel);

		objectMapper.writeValue(resp.getOutputStream(), newsModel);

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();

		req.setCharacterEncoding("UTF-8");

		resp.setContentType("application/json");

		NewsModel updateNews = HttpUtil.of(req.getReader()).toModel(NewsModel.class);

		updateNews = newsService.update(updateNews);

		objectMapper.writeValue(resp.getOutputStream(), updateNews);

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();

		req.setCharacterEncoding("UTF-8");

		resp.setContentType("application/json");

		NewsModel newsModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class);

		newsService.delete(newsModel.getIds());

		objectMapper.writeValue(resp.getOutputStream(), "{}");
	}

	private void saveOrUpdate() {

	}

}
