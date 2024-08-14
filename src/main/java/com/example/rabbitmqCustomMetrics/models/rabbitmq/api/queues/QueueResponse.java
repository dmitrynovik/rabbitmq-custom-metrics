package com.example.rabbitmqCustomMetrics.models.rabbitmq.api.queues;

public class QueueResponse {
    private boolean auto_delete;
    private float consumer_capacity;
    private float consumer_utilisation;
    private float consumers;
    private boolean durable;
    private boolean exclusive;
    private String exclusive_consumer_tag = null;
    Garbage_collection Garbage_collectionObject;
    private String head_message_timestamp = null;
    private String idle_since;
    private float memory;
    private float message_bytes;
    private float message_bytes_paged_out;
    private float message_bytes_persistent;
    private float message_bytes_ram;
    private float message_bytes_ready;
    private float message_bytes_unacknowledged;
    private float messages;
    Messages_details Messages_detailsObject;
    private float messages_paged_out;
    private float messages_persistent;
    private float messages_ram;
    private float messages_ready;
    Messages_ready_details Messages_ready_detailsObject;
    private float messages_ready_ram;
    private float messages_unacknowledged;
    Messages_unacknowledged_details Messages_unacknowledged_detailsObject;
    private float messages_unacknowledged_ram;
    private String name;
    private String node;
    private String operator_policy;
    private String policy = null;
    private String recoverable_slaves = null;
    private float reductions;
    Reductions_details Reductions_detailsObject;
    private String single_active_consumer_tag = null;
    private String state;
    private float storage_version;
    private String type;
    private String vhost;
    private Effective_policy_definition effective_policy_definition;
  
   // Getter Methods 
  
    public Effective_policy_definition getEffective_policy_definition() {
      return effective_policy_definition;
    }

    public void setEffective_policy_definition(Effective_policy_definition effective_policy_definition) {
      this.effective_policy_definition = effective_policy_definition;
    }

    public boolean getAuto_delete() {
      return auto_delete;
    }
  
    public float getConsumer_capacity() {
      return consumer_capacity;
    }
  
    public float getConsumer_utilisation() {
      return consumer_utilisation;
    }
  
    public float getConsumers() {
      return consumers;
    }
  
    public boolean getDurable() {
      return durable;
    }
  
    public boolean getExclusive() {
      return exclusive;
    }
  
    public String getExclusive_consumer_tag() {
      return exclusive_consumer_tag;
    }
  
    public Garbage_collection getGarbage_collection() {
      return Garbage_collectionObject;
    }
  
    public String getHead_message_timestamp() {
      return head_message_timestamp;
    }
  
    public String getIdle_since() {
      return idle_since;
    }
  
    public float getMemory() {
      return memory;
    }
  
    public float getMessage_bytes() {
      return message_bytes;
    }
  
    public float getMessage_bytes_paged_out() {
      return message_bytes_paged_out;
    }
  
    public float getMessage_bytes_persistent() {
      return message_bytes_persistent;
    }
  
    public float getMessage_bytes_ram() {
      return message_bytes_ram;
    }
  
    public float getMessage_bytes_ready() {
      return message_bytes_ready;
    }
  
    public float getMessage_bytes_unacknowledged() {
      return message_bytes_unacknowledged;
    }
  
    public float getMessages() {
      return messages;
    }
  
    public Messages_details getMessages_details() {
      return Messages_detailsObject;
    }
  
    public float getMessages_paged_out() {
      return messages_paged_out;
    }
  
    public float getMessages_persistent() {
      return messages_persistent;
    }
  
    public float getMessages_ram() {
      return messages_ram;
    }
  
    public float getMessages_ready() {
      return messages_ready;
    }
  
    public Messages_ready_details getMessages_ready_details() {
      return Messages_ready_detailsObject;
    }
  
    public float getMessages_ready_ram() {
      return messages_ready_ram;
    }
  
    public float getMessages_unacknowledged() {
      return messages_unacknowledged;
    }
  
    public Messages_unacknowledged_details getMessages_unacknowledged_details() {
      return Messages_unacknowledged_detailsObject;
    }
  
    public float getMessages_unacknowledged_ram() {
      return messages_unacknowledged_ram;
    }
  
    public String getName() {
      return name;
    }
  
    public String getNode() {
      return node;
    }
  
    public String getOperator_policy() {
      return operator_policy;
    }
  
    public String getPolicy() {
      return policy;
    }
  
    public String getRecoverable_slaves() {
      return recoverable_slaves;
    }
  
    public float getReductions() {
      return reductions;
    }
  
    public Reductions_details getReductions_details() {
      return Reductions_detailsObject;
    }
  
    public String getSingle_active_consumer_tag() {
      return single_active_consumer_tag;
    }
  
    public String getState() {
      return state;
    }
  
    public float getStorage_version() {
      return storage_version;
    }
  
    public String getType() {
      return type;
    }
  
    public String getVhost() {
      return vhost;
    }
  
   // Setter Methods 
  
  
    public void setAuto_delete( boolean auto_delete ) {
      this.auto_delete = auto_delete;
    }
  
    public void setConsumer_capacity( float consumer_capacity ) {
      this.consumer_capacity = consumer_capacity;
    }
  
    public void setConsumer_utilisation( float consumer_utilisation ) {
      this.consumer_utilisation = consumer_utilisation;
    }
  
    public void setConsumers( float consumers ) {
      this.consumers = consumers;
    }
  
    public void setDurable( boolean durable ) {
      this.durable = durable;
    }
  
    public void setExclusive( boolean exclusive ) {
      this.exclusive = exclusive;
    }
  
    public void setExclusive_consumer_tag( String exclusive_consumer_tag ) {
      this.exclusive_consumer_tag = exclusive_consumer_tag;
    }
  
    public void setGarbage_collection( Garbage_collection garbage_collectionObject ) {
      this.Garbage_collectionObject = garbage_collectionObject;
    }
  
    public void setHead_message_timestamp( String head_message_timestamp ) {
      this.head_message_timestamp = head_message_timestamp;
    }
  
    public void setIdle_since( String idle_since ) {
      this.idle_since = idle_since;
    }
  
    public void setMemory( float memory ) {
      this.memory = memory;
    }
  
    public void setMessage_bytes( float message_bytes ) {
      this.message_bytes = message_bytes;
    }
  
    public void setMessage_bytes_paged_out( float message_bytes_paged_out ) {
      this.message_bytes_paged_out = message_bytes_paged_out;
    }
  
    public void setMessage_bytes_persistent( float message_bytes_persistent ) {
      this.message_bytes_persistent = message_bytes_persistent;
    }
  
    public void setMessage_bytes_ram( float message_bytes_ram ) {
      this.message_bytes_ram = message_bytes_ram;
    }
  
    public void setMessage_bytes_ready( float message_bytes_ready ) {
      this.message_bytes_ready = message_bytes_ready;
    }
  
    public void setMessage_bytes_unacknowledged( float message_bytes_unacknowledged ) {
      this.message_bytes_unacknowledged = message_bytes_unacknowledged;
    }
  
    public void setMessages( float messages ) {
      this.messages = messages;
    }
  
    public void setMessages_details( Messages_details messages_detailsObject ) {
      this.Messages_detailsObject = messages_detailsObject;
    }
  
    public void setMessages_paged_out( float messages_paged_out ) {
      this.messages_paged_out = messages_paged_out;
    }
  
    public void setMessages_persistent( float messages_persistent ) {
      this.messages_persistent = messages_persistent;
    }
  
    public void setMessages_ram( float messages_ram ) {
      this.messages_ram = messages_ram;
    }
  
    public void setMessages_ready( float messages_ready ) {
      this.messages_ready = messages_ready;
    }
  
    public void setMessages_ready_details( Messages_ready_details messages_ready_detailsObject ) {
      this.Messages_ready_detailsObject = messages_ready_detailsObject;
    }
  
    public void setMessages_ready_ram( float messages_ready_ram ) {
      this.messages_ready_ram = messages_ready_ram;
    }
  
    public void setMessages_unacknowledged( float messages_unacknowledged ) {
      this.messages_unacknowledged = messages_unacknowledged;
    }
  
    public void setMessages_unacknowledged_details( Messages_unacknowledged_details messages_unacknowledged_detailsObject ) {
      this.Messages_unacknowledged_detailsObject = messages_unacknowledged_detailsObject;
    }
  
    public void setMessages_unacknowledged_ram( float messages_unacknowledged_ram ) {
      this.messages_unacknowledged_ram = messages_unacknowledged_ram;
    }
  
    public void setName( String name ) {
      this.name = name;
    }
  
    public void setNode( String node ) {
      this.node = node;
    }
  
    public void setOperator_policy( String operator_policy ) {
      this.operator_policy = operator_policy;
    }
  
    public void setPolicy( String policy ) {
      this.policy = policy;
    }
  
    public void setRecoverable_slaves( String recoverable_slaves ) {
      this.recoverable_slaves = recoverable_slaves;
    }
  
    public void setReductions( float reductions ) {
      this.reductions = reductions;
    }
  
    public void setReductions_details( Reductions_details reductions_detailsObject ) {
      this.Reductions_detailsObject = reductions_detailsObject;
    }
  
    public void setSingle_active_consumer_tag( String single_active_consumer_tag ) {
      this.single_active_consumer_tag = single_active_consumer_tag;
    }
  
    public void setState( String state ) {
      this.state = state;
    }
  
    public void setStorage_version( float storage_version ) {
      this.storage_version = storage_version;
    }
  
    public void setType( String type ) {
      this.type = type;
    }
  
    public void setVhost( String vhost ) {
      this.vhost = vhost;
    }
  }
