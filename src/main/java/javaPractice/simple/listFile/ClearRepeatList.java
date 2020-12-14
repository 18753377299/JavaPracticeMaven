package javaPractice.simple.listFile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
	 * @功能：去除包含对象的重复数据
	 * @param 
	 * @return TyphoonLatestInfo
	 * @author liqiankun
	 * @时间：20190903
	 * @修改记录：
	 */
public class ClearRepeatList {
	public static void main(String []args){
		List<History> historyList = new ArrayList<History>();
		
		History history = new History();
		HistoryId id = new HistoryId();
		id.setName("11");
		id.setType("aa");
		history.setId(id);
		history.setWord("AA");
		historyList.add(history);
		
		History historyB = new History();
		HistoryId idB = new HistoryId();
		idB.setName("11");
		idB.setType("aa");
		historyB.setId(id);
		historyB.setWord("BB");
		historyList.add(historyB);
		
		List<History> historyListNew = clearTyphoonRepeatData(historyList);
		System.out.println(historyListNew);
	}
	public static List<History> clearTyphoonRepeatData(List<History> typhoonLatestInfoListOld){
//		List<History> typhoonLatestInfoList =new ArrayList<History>();
		List<History> typhoonHistoryPathLisClear = new ArrayList<History>();
		try {
				//去除重复数据
				Set<History> typhoonHistoryPathSet = new HashSet<History>();
				typhoonHistoryPathSet.addAll(typhoonLatestInfoListOld);
				typhoonHistoryPathLisClear.addAll(typhoonHistoryPathSet);
				// 
//				typhoonLatestInfoList.add(typhoonLatestInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return typhoonHistoryPathLisClear;
	}
}

class History{
	private HistoryId id ;
	private String word;
	public HistoryId getId() {
		return id;
	}
	public void setId(HistoryId id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		History other = (History) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

class HistoryId{
	private String type;
	private String name;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoryId other = (HistoryId) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
	
}
