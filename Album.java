package datastructuers;


public class Album {
	String name;
	String condition;
	PhotoManager manager; 
	int totalnbcomp=0;
	
	
	Album(String name,String condition, PhotoManager manager)	{
		this.name=name;
		this.condition=condition;
		this.manager=manager;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCondition() {
		return condition;
	}
	
	public PhotoManager getManager() {
		return manager;
	}

	public boolean Tag_Exist_in_photo(LinkedList<String>L,String tag) {
		if(L.empty()) return false;
		L.findFirst();
		while(!L.last())
		{
			totalnbcomp++;
			if(L.retrieve().equals(tag)) {
				System.out.println(tag+ "Exist total number of comp= "+totalnbcomp);
				return true;
			}
			L.findNext();
		}
		totalnbcomp++;
		if(L.retrieve().equals(tag)) {
			System.out.println(tag+ "Exist total number of comp= "+totalnbcomp);
			return true; }
		System.out.println(tag+ " not Exist total number of comp= "+totalnbcomp);
		return false;
			
	}
	
	
	public boolean subset(String []A, LinkedList<String>B) {
	if (A.length==0)
	return true;
	if (B.empty())
	return false;
	for (int i=0;i<A.length; i++) {
	if(!Tag_Exist_in_photo(B, A[i])) {
	return false;
	}}
	return true;
	}	
	
	
	public LinkedList<Photo> getPhotos(){
		LinkedList<Photo>allPhotos=manager.getPhotos();
        LinkedList<Photo> res=new LinkedList<Photo>();
		if(allPhotos.empty()) return res;

		if(condition==null) return res;
		if(condition.equals("")) return allPhotos;
		String a[]=condition.split("AND");
		for(int i=0;i<a.length; i++) {
		a[i]=a[i].trim();
		}
		allPhotos.findFirst();
		while(!allPhotos.last()) {
			if(subset(a,allPhotos.retrieve().getTag())) {
			res.insert(allPhotos.retrieve());
			}
			allPhotos.findNext();
		}
		if(subset(a,allPhotos.retrieve().getTag())) {
			res.insert(allPhotos.retrieve());
			}
		return res;
	}

	
	public int getTotalnbcomp() {
		return totalnbcomp;
	}
	
}
