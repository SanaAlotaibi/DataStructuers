package datastructuers;

public class Album_inverted_index {
	String name;
	String condition;
	InvIndexPhotoManager manager;
	
	Album_inverted_index(String name,String condition,InvIndexPhotoManager manager)	{
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

	public InvIndexPhotoManager getManager() {
		return manager;
	}
	
	public boolean Photo_Exist(LinkedList<Photo>L, Photo p) {
		if(L.empty()) return false;
		L.findFirst();
		while(!L.last())
		{
			if(L.retrieve().path.equals(p.path))
				return true;
			L.findNext();
		}
		if(L.retrieve().path.equals(p.path))
			return true;
		return false;
	}
	
	
	
	public LinkedList<Photo> getTagPhotos(String tag){
        LinkedList<Photo> res=new LinkedList<Photo>();
boolean found=manager.getPhotos().findKey1(tag);
if(found)
	res=manager.getPhotos().retrieve();

return res;
	}
	
	public LinkedList<Photo> And(LinkedList<Photo>A,LinkedList<Photo>B){
		   LinkedList<Photo> result=new LinkedList<Photo>();	
		   if(A.empty() || B.empty())
			   return result;
		   A.findFirst();
		   while(true) {
			   boolean found=Photo_Exist(result, A.retrieve())  ;
			   if(! found) {
				   B.findFirst();
				   while(true) {
					   if(B.retrieve().path.equals(A.retrieve().path)) {
						   result.insert(A.retrieve())  ;
						   break;
					   }
					   if(! B.last())
						   B.findNext();
					   else
						   break;
				   }
			   }
			   if(! A.last())
				   A.findNext();
			   else
				   break;
		   }
		   return result;
	}
	
	public LinkedList<Photo> getPhotos(){
        LinkedList<Photo> res=new LinkedList<Photo>();
        if(condition==null) return res;
		if(condition.equals("")) return allPhotos;
		String a[]=condition.split("AND");
		for(int i=0;i<a.length; i++) {
		a[i]=a[i].trim();
		}	
        LinkedList<Photo>A=getTagPhotos(a[0]);
        for(int i=0;i<a.length; i++) {
    		System.out.println("a[i]= "+a[i]);
    		A=And(A, B);
    		}	

		return A;	
	}
	
	
public int getNbComps()	{
	return manager.index.num_comp;
}	
	
}
