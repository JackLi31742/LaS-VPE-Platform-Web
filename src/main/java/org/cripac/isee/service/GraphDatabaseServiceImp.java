package org.cripac.isee.service;

import java.util.Date;

import org.cripac.isee.controller.GraphDatabaseController;
import org.cripac.isee.dao.GraphDatabaseConnectorDao;
import org.cripac.isee.entity.Attributes;
import org.cripac.isee.entity.Link;
import org.cripac.isee.entity.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GraphDatabaseServiceImp implements GraphDatabaseService{
	@Autowired
	private GraphDatabaseConnectorDao graphDatabaseConnectorDao;

	private final Logger log = LoggerFactory.getLogger(GraphDatabaseServiceImp.class);
	@Override
	public Attributes getNodeByID(String id) {
		// TODO Auto-generated method stub
		return graphDatabaseConnectorDao.getPedestrianAttributes(id);
	}

	@Override
	public Node[] getNodesByAttributes(Object[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getLinkProperties(String id1, String id2) {
		// TODO Auto-generated method stub
		return graphDatabaseConnectorDao.getPedestrianSimilarity(id1, id2);
	}

	@Override
	public String[] getLinkedNodes(String id1) {
		// TODO Auto-generated method stub
		Link[] links=graphDatabaseConnectorDao.getLinkedPedestrians(id1);
		log.info(links.toString());
		String [] id2s=new String[links.length];
		
		for (int i = 0; i < links.length; i++) {
			id2s[i]=links[i].getId2();
			log.info(id2s[i]);
		}
		return id2s;
	}

	@Override
	public String getOneFrameFromTrajs(String[] cam_id_array, Date startTime, Date endTime, Date standardTime) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
	