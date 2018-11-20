package com.imdb.db;

import java.util.List;

import com.imdb.business.Identifiable;

public class MasterDB {
	
	protected static int getNextId(List<? extends Identifiable> list) {
		int nextId = 0;
		
		for (Identifiable i: list) {
			nextId = Integer.max(nextId, i.getId());
		}
		return nextId+1;
	}

}
