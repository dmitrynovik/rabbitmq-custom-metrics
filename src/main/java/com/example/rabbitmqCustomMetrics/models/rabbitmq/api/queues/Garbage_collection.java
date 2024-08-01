package com.example.rabbitmqCustomMetrics.models.rabbitmq.api.queues;

public class Garbage_collection {
    private float fullsweep_after;
    private float max_heap_size;
    private float min_bin_vheap_size;
    private float min_heap_size;
    private float minor_gcs;
  
  
   // Getter Methods 
  
    public float getFullsweep_after() {
      return fullsweep_after;
    }
  
    public float getMax_heap_size() {
      return max_heap_size;
    }
  
    public float getMin_bin_vheap_size() {
      return min_bin_vheap_size;
    }
  
    public float getMin_heap_size() {
      return min_heap_size;
    }
  
    public float getMinor_gcs() {
      return minor_gcs;
    }
  
   // Setter Methods 
  
    public void setFullsweep_after( float fullsweep_after ) {
      this.fullsweep_after = fullsweep_after;
    }
  
    public void setMax_heap_size( float max_heap_size ) {
      this.max_heap_size = max_heap_size;
    }
  
    public void setMin_bin_vheap_size( float min_bin_vheap_size ) {
      this.min_bin_vheap_size = min_bin_vheap_size;
    }
  
    public void setMin_heap_size( float min_heap_size ) {
      this.min_heap_size = min_heap_size;
    }
  
    public void setMinor_gcs( float minor_gcs ) {
      this.minor_gcs = minor_gcs;
    }
  }