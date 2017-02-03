package org.cripac.isee.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cripac.isee.entity.Attributes;
import org.cripac.isee.service.GraphDatabaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.sun.jersey.core.util.StringIgnoreCaseKeyComparator;

@Controller
public class GraphDatabaseController{
	@Autowired
	private GraphDatabaseService graphDatabaseService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	private final Logger log = LoggerFactory.getLogger(GraphDatabaseController.class);

	/**
	 * 根据ID返回Node属性
	 * @param id
	 * @return node的全部属性（json格式）
	 */
	@RequestMapping("/getNodeByID")
	@ResponseBody
	public String getNodeByID(@RequestParam String id) {
		log.info("id:" + id);
		Attributes attributes = graphDatabaseService.getNodeByID(id);
//		System.out.println(attributes);
		log.info("getNodeByID");
		log.info("attributes:"+attributes);
		String nodes = new Gson().toJson(attributes);
		log.info("nodes:"+nodes);
		return nodes;

	}
	
	/**
	 * 测试
	 */
	@RequestMapping("/ajax")
	@ResponseBody
	public String ajax(@RequestParam String id) {
//		String id=request.getParameter("id");
		System.out.println("ajax test:"+id);
		return new Gson().toJson("9");

	}

	/**
	 * 获取具有相同属性（一个或多个属性）的Node
	 * @param args
	 */
	@RequestMapping("/getNodesByAttributes")
	@ResponseBody
	public void getNodesByAttributes(@RequestParam Object[] args) {
		// TODO Auto-generated method stub
		// ModelAndView mav = new ModelAndView();
		// return null;
	}

	
	/**
	 * 获取两个node 间的连接关系
	 * @param id1
	 * @param id2
	 * @return
	 */
	@RequestMapping("/getLinkProperties")
	@ResponseBody
	public String getLinkProperties(@RequestParam String id1, @RequestParam String id2) {
		// TODO Auto-generated method stub
		log.info("id1:" + id1 + " ," + "id2:" + id2);
		float similarity = graphDatabaseService.getLinkProperties(id1, id2);
		log.info("getLinkProperties");
		log.info("similarity：" + similarity);

		String similarityToJson = new Gson().toJson(similarity);
		
		return similarityToJson;
	}

	/**
	 * 获取与某一个node 相连的全部node 的id
	 * @param id1
	 * @return
	 */
	@RequestMapping("/getLinkedNodes")
	@ResponseBody
	public String getLinkedNodes(@RequestParam String id1) {
		// TODO Auto-generated method stub
		log.info("id1:" + id1);
		String[] ids = graphDatabaseService.getLinkedNodes(id1);
		for (int i = 0; i < ids.length; i++) {
			log.info(ids[i]);
		}
		String idsToJson = new Gson().toJson(ids);
		
		return idsToJson;
	}

	

	@RequestMapping("/getvideosPath")
	@ResponseBody
	public String getvideosPath() {
		// TODO Auto-generated method stub
		// 路径
		// 得到了服务器的本地路径
		// String realPath =
		// request.getSession().getServletContext().getRealPath("/");
		// System.out.println(realPath);
		// url
		// String urlPath=request.getRequestURL().toString() ;

		// System.out.println(urlPath);
		// System.out.println(request.getContextPath());

		// web项目名称request.getContextPath()
		String ctxPath = request.getContextPath();
		// 网页路径
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ ctxPath + "/";
		// System.out.println(ctxPath);
		// System.out.println(basePath);
		// log.info("realPath:"+realPath);
		String camId01 = "CAM01";
		String camId02 = "CAM02";
		String date = "2014-04-24";
		String videosPath = basePath + "data/videos" + camId01 + date;
		
		return "";

	}

	/**
	 * 摄像机场景图
	 * @return
	 */
	@RequestMapping("/getSceneImgPaths")
	public @ResponseBody void getSceneImgPaths() {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		// 路径
		// 得到了服务器的本地路径
		String realPath = request.getSession().getServletContext().getRealPath("/");

		// web项目名称request.getContextPath()
		String ctxPath = request.getContextPath();
		// 网页路径
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ ctxPath + "/";

		String background_images = "background_images";
		String background_imagesPath = basePath + "data/" + background_images + "/";
		log.info("background_imagesPath:" + background_imagesPath);
		for (int i = 1; i <= 32; i++) {

			log.info("background_images_file" + i);
			mav.addObject("background_images_file" + i, background_imagesPath + i + ".jpg");
			session.setAttribute("background_images_file" + i, background_imagesPath + i + ".jpg");
		}

		// mav.setViewName("redirect:index.jsp");
	}

	
	
	/**
	 * 获取Tracking 结果的一帧轨迹
	 * @param cam_id_array
	 * @param startTime
	 * @param endTime
	 * @param standardTime
	 */
	@RequestMapping("/getOneFrameFromTrajs")
	@ResponseBody
	public void getOneFrameFromTrajs(@RequestParam String[] cam_id_array, @RequestParam Date startTime,
			@RequestParam Date endTime, @RequestParam Date standardTime) {
		// TODO Auto-generated method stub
				// 路径
				// 得到了服务器的本地路径
				String realPath = request.getSession().getServletContext().getRealPath("/");

				String ctxPath = request.getContextPath();
				// 网页路径
				String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
						+ ctxPath + "/";

				String boundingboxes = "boundingboxes";
				String boundingboxesPath = basePath + "data/" + boundingboxes;
				File dir = new File(boundingboxesPath);
				log.info("boundingboxesPath:" + boundingboxesPath);
	}
	
	@RequestMapping("/getTrajsInfoByTarID")
	@ResponseBody
	public Map<String, Object> getTrajsInfoByTarID(@RequestParam String id){
		String boundingboxesPath="";
		String startTime="";
		String endTime="";
		String video_hdfs_path="";
		Map<String, Object> map=new HashMap<>();
		map.put("boundingboxesPath", boundingboxesPath);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("video_hdfs_path", video_hdfs_path);
		return map;
	}
	
	
	@RequestMapping("/getReIDResults")
	@ResponseBody
	public String[][] getReIDResults(@RequestParam Date date){
		
		String [] personIds=null;
		String[][] target_ids=null; 
		return target_ids;
	}
	
	@RequestMapping("/getAllTargetsImageOfOnePerson")
	@ResponseBody
	public String[] getAllTargetsImageOfOnePerson(@RequestParam Date date,@RequestParam String id){
		
		String [] tars_imgs_paths=null;
		return tars_imgs_paths;
	}
	@RequestMapping("/getAttributes")
	@ResponseBody
	public String getAttributes(@RequestParam Date date,@RequestParam String id){
		
		Attributes attributes=null;
		return new Gson().toJson(attributes);
	}
	@RequestMapping("/doQuery")
	@ResponseBody
	public String doQuery(@RequestParam Attributes attributesIn){
		
		Attributes attributesOut=null;
		return new Gson().toJson(attributesOut);
	}
	@RequestMapping("/run")
	@ResponseBody
	public String run(@RequestParam String[] cam_id_array, @RequestParam Date startTime,
			@RequestParam Date endTime, @RequestParam Date standardTime){
		
		Attributes attributesOut=null;
		return new Gson().toJson(attributesOut);
	}
	
	@RequestMapping("/getEfficiency")
	@ResponseBody
	public String getEfficiency(){
		double frames=0;
		double second=System.currentTimeMillis();
		return new Gson().toJson(frames/second);
	}
	@RequestMapping("/getProcessProgress")
	@ResponseBody
	public String getProcessProgress(){
		double progress=0;
		return new Gson().toJson(progress);
	}
	
	@RequestMapping("/getPrecision")
	@ResponseBody
	public String getPrecision(){
		double []progress=null;
		return new Gson().toJson(progress);
	}
	
	@RequestMapping("/getSpeed")
	@ResponseBody
	public String getSpeed(){
		double []speed=null;
		return new Gson().toJson(speed);
	}
	
	/**
	 * 得到方法
	 * @param module
	 */
	@RequestMapping("/getMethods")
	@ResponseBody
	public void getMethods(@RequestParam String[] module){
		for (int i = 0; i < module.length; i++) {
			log.info(module[i]);
		}
	}
	/**
	 * 回溯
	 * @return
	 */
	@RequestMapping("/getBacktracking")
	@ResponseBody
	public String getBacktracking(){
	
		String startTime="20";
		return startTime;
	
	}
	
	
	
	
}
