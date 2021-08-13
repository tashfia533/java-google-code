package com.google;
import java.util.Random;
import  java.util.ArrayList;
public class VideoPlayer {

  private final VideoLibrary videoLibrary;
  private String currentVideo=null;
  private boolean vidPaused;
  private String vidState;


  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
    vidPaused=false;
    vidState=" ";


  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    System.out.println("Here's a list of all available videos");
    for(Video v:videoLibrary.getVideos()) {
      System.out.println(v.getTitle()+"("+v.getVideoId()+")"+v.getTags());
    }

  }

  public void playVideo(String videoId) {
    boolean isNotFound=true;
    for(Video vid:videoLibrary.getVideos()) {
      if (vid.getVideoId().equals(videoId)) {
        isNotFound = false;
        break;
      }
    }
    if (isNotFound) {
      System.out.println("Cannot play video: Video doesn't exist");
      return;
    }
    if(currentVideo==null) {
      currentVideo=videoId;
      System.out.println("Playing video:"+videoId);
      return;
    }
    if (currentVideo!=videoId) {
      System.out.println("Stopping video"+currentVideo);
      return;
    }
    currentVideo=videoId;
    System.out.println("Playing video:"+videoId);
    vidPaused=true;


  }

  public void stopVideo() {
    if (currentVideo==null) {
      System.out.println("Cannot stop video: No video is currently playing");
      return;
    }

    System.out.println("stopVideo:"+currentVideo);
    currentVideo=null;

  }

  public void playRandomVideo() {
    Random rand= new Random();
    if(currentVideo!=null){
      stopVideo();
      return;
    }

    int rnd = rand.nextInt(videoLibrary.getVideos().size());
    ArrayList<Video> vidCollection= new ArrayList<>();
    for (Video vids: videoLibrary.getVideos()) {
      vidCollection.add(vids);

    }
    playVideo(vidCollection.get(rnd).getVideoId());
  }

  public void pauseVideo() {
    if (currentVideo==null) {
      System.out.println("Cannot pause video: No video is playing");
      return;
    }

    System.out.println("pauseVideo:"+currentVideo);
    vidPaused=true;
    if (vidPaused=true){
      System.out.println("Video already paused"+currentVideo);
      return;
    }
  }

  public void continueVideo() {
    if (currentVideo==null){
      System.out.println("Cannot continue video: No video is currently playing");
      return;
    }
    if (vidPaused=false){
      System.out.println("Cannot continue video: Video is not paused");
      return;
    }
    System.out.println("continuing Video:"+currentVideo);
    vidPaused=false;
  }

  public void showPlaying() {
    if (currentVideo==null) {
      System.out.println("No video is currently playing");
      return;
    }
    if (vidPaused=true){
      vidState="Paused";
      return;

    }
    Video vid=videoLibrary.getVideo(currentVideo);
    System.out.println("Currently playing:"+vid.getTitle()+"("+vid.getVideoId()+")"+vid.getTags()+vidState);
  }

  public void createPlaylist(String playlistName) {
    System.out.println("createPlaylist needs implementation");
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}