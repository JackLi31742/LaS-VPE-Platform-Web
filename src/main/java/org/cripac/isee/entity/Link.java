package org.cripac.isee.entity;

import javax.annotation.Nonnull;

/**
 * Link这个类存储了一个结点和所有相连结点的相似度。
 *
 * @author Ken Yu, CRIPAC, 2016
 */
public class Link {
    private String id1;
    private String id2;
    private float similarity;

    public Link() {
    }

    public Link(@Nonnull String id1,
                @Nonnull String id2,
                @Nonnull float similarity) {
        this.id1 = id1;
        this.id2 = id2;
        this.similarity = similarity;
    }

	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public String getId2() {
		return id2;
	}

	public void setId2(String id2) {
		this.id2 = id2;
	}

	public float getSimilarity() {
		return similarity;
	}

	public void setSimilarity(float similarity) {
		this.similarity = similarity;
	}

	@Override
	public String toString() {
		return "Link [id1=" + id1 + ", id2=" + id2 + ", similarity=" + similarity + "]";
	}
    
	
    
}
