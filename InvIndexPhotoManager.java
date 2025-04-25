package com.mycompany.rojectcsc212;

public class InvIndexPhotoManager {
    private LinkedList<Photo> photos;
    private BST<LinkedList<Photo>> invertedIndex;

    public InvIndexPhotoManager() {
        photos = new LinkedList<>();
        invertedIndex = new BST<>();
    }

    public void addPhoto(Photo p) {
        photos.insert(p);
        LinkedList<String> tags = p.getTags();
        tags.startTraversal();
        while (tags.hasNext()) {
            String tag = tags.next();
            LinkedList<Photo> photosWithTags = invertedIndex.find(tag);
            if (photosWithTags == null) {
                photosWithTags = new LinkedList<>();
                invertedIndex.insert(tag, photosWithTags);
            }
            photosWithTags.insert(p);
        }
    }

    public void removePhoto(String path) {
        photos.startTraversal();
        
        while (photos.hasNext()) {
            Photo p = photos.next();
            
            if (p.getPath().equals(path)) {
                photos.remove(p);
                LinkedList <String> tags = p.getTags();
                tags.startTraversal();
                
                while (tags.hasNext()) {
                    String tag = tags.next();
                    LinkedList<Photo> photosWithTags = invertedIndex.find(tag);
                    
                    if (photosWithTags != null) {
                        photosWithTags.remove(p);
                        
                        if (photosWithTags.isEmpty()) {
                            invertedIndex.remove(tag);
                        }
                    }
                }
                return;
            }
        }
    }

    public LinkedList<Photo> getPhotos() {
        return photos;
    }

    public BST<LinkedList<Photo>> getInvertedIndex() {
        return invertedIndex;
    }
}




