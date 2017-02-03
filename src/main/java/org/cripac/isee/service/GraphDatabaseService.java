package org.cripac.isee.service;

import java.util.Date;

import org.cripac.isee.entity.Attributes;
import org.cripac.isee.entity.Node;

public interface GraphDatabaseService {

	/**
	 * 根据ID返回Node属性
	 * @param id
	 * @return
	 */
	public Attributes getNodeByID(String id);
	
	/**
	 * 获取具有相同属性（一个或多个属性）的Node
	 * @param args
	 * @return
	 */
	public Node[] getNodesByAttributes(Object[] args) ;
	
	
	/**
	 * 获取两个node间的连接关系
	 * @param id1
	 * @param id2
	 * @return
	 */
	public float getLinkProperties(String id1,String id2);
	
	/**
	 * 获取与某一个node相连的全部node的id
	 * @param id
	 * @return
	 */
	public String[] getLinkedNodes(String id1);
		
	/**
	 * 获取Tracking结果的一帧轨迹
	 * @return
	 */
	public String getOneFrameFromTrajs(String[] cam_id_array,
			Date startTime,Date endTime,Date standardTime );
 }
