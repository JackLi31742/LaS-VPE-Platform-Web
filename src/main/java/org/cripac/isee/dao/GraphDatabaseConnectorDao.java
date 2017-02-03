/***********************************************************************
 * This file is part of LaS-VPE Platform.
 *
 * LaS-VPE Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * LaS-VPE Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with LaS-VPE Platform.  If not, see <http://www.gnu.org/licenses/>.
 ************************************************************************/

package org.cripac.isee.dao;

import java.util.NoSuchElementException;

import javax.annotation.Nonnull;

import org.cripac.isee.entity.Attributes;
import org.cripac.isee.entity.Link;

/**
 * GraphDatabaseConnector是访问数据库的一个基类。
 * @author Ken Yu, CRIPAC, 2016
 */
public interface  GraphDatabaseConnectorDao {

    /**
     * 
	 * 将行人的轨迹图片所放的目录（HDFS中某个目录）存到数据库。
     *
     * @param id   一个行人的id
     * @param path 存放轨迹（一系列图片）的目录
     */
    public abstract void setTrackSavingPath(@Nonnull String id,
                                            @Nonnull String path);

    /**
     * 读取行人的轨迹图片所放的目录。
     *
     * @param id 	一个行人的id
     * @return 		存放轨迹（一系列图片）的目录
     * @throws NoSuchElementException 如果数据库中没有这个id的结点，
	 * 或者有这个结点但结点没有path信息，则抛出异常。
     */
    public abstract String getTrackletSavingDir(@Nonnull String id) throws NoSuchElementException;

    /**
     * 保存两个行人之间的相似度（两个结点之间建立一条边）。
     *
     * @param idA        第一个行人的id
     * @param idB        第二个行人的id
     * @param similarity 两人之间的相似度
     */
    public abstract void setPedestrianSimilarity(@Nonnull String idA,
                                                 @Nonnull String idB,
                                                 float similarity);

    /**
     * 读取两个行人之间的相似度（两个结点之间边的值）。
     *
     * @param idA 	第一个行人的id
     * @param idB 	第二个行人的id
     * @return 		两人之间的相似度
     * @throws NoSuchElementException 如果数据库中找不到一个或两个结点，
	 * 或者找到这两个结点但它们之间没有边，则抛出异常。
     */
    public abstract float getPedestrianSimilarity(@Nonnull String idA,
                                                  @Nonnull String idB) throws NoSuchElementException;

    /**
     * 保存一个行人的属性（把attr的每个成员变量作为这个行人结点的一个property保存到数据库）。
     *
     * @param id   一个行人的id
     * @param attr 一个行人的属性，这个对象包含很多成员变量
     */
    public abstract void setPedestrianAttributes(@Nonnull String id,
                                                 @Nonnull Attributes attr);

    /**
     * 读取一个行人的属性（将数据库中对应这个id的结点所有property读取出来，包装成一个Attributes对象返回）
     *
     * @param id 	一个行人的id
     * @return		一个行人的属性，这个对象包含很多成员变量
     * @throws NoSuchElementException 如果数据库中找不到对应这个id的行人结点，则抛出异常
     */
    public abstract Attributes getPedestrianAttributes(@Nonnull String id) throws NoSuchElementException;

    /**
     * 返回跟目标行人结点有连接边的所有行人结点以及相似度。
     *
     * @param id 	目标行人结点的id
     * @return 		返回与目标结点连接的所有id号，以及相似度，返回的数组可能为空
					（目标结点不与任何其他行人结点相连）。
     * @throws NoSuchElementException 如果数据库中找不到对应这个id的行人结点，则抛出异常
     */
    public abstract Link[] getLinkedPedestrians(@Nonnull String id) throws NoSuchElementException;

    
}
