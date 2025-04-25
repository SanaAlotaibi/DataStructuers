public class PhotoManager {
LinkedList<Photo>allPhotos;

 public PhotoManager();{
allPhotos=new LinkedList<Photo>();
 }
 public LinkedList<Photo> getPhotos();
 // Add a photo
 public void addPhoto(Photo p){
	 if(Photo_Exist(allPhotos,p) return ;
	 allPhotos.insert(p);
 }

 public void deletePhoto(String path)
 { if(allPhotos.empty()) return ; 

 allPhotos.findfirst();
 
 while(!allPhotos.last())
 {
	 if(allPhotos.retrieve().path.equals(path){
		 allPhotos.remove();
		 break;
 }
 else
	 allPhotos.findNext();
 
 }
  if(allPhotos.retrieve().path.equals(path){
  allPhotos.remove();}
 }
  public LinkedList<Photo> getPhotos(){
  return allPhotos;
  }
  
 public boolean Photo_Exist(LinkedList<Photo> L , p ){
	 if (L.empty()) return false;
	 L.findFirst();
	 while(!L.last()){
	 if(L.retrieve().path.equals(p.path))
		 return true; 
	 L.findNext();
	 }
