package me.sw123.modreq.querry;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuerryQue {
	
	private ArrayList<IQuerry> que;
	
	public QuerryQue(){
		que = new ArrayList<IQuerry>();
	}
	public void executeNext(Connection conn) throws SQLException{
		IQuerry q = que.get(0);
		q.execute(conn);
		q.onComplete();
		que.remove(0);
	}
	public boolean hasNext(){
		return que.size() > 0 ? true : false;
	}
	public void addQuerryToQue(IQuerry q){
		que.add(q);
	}
}
