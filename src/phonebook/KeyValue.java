package phonebook;

public class KeyValue {

    private Object key;
    private String value;

    public KeyValue() {
    }
    
    public KeyValue(Object key, String value) {
	  this.key = key;
	  this.value = value;
    }
    
    public KeyValue(Object key, Object value) {
	  this(key, value.toString());
    }

    public Object getKey() {
	  return this.key;
    }
    
    public String getKeyString() {
	  return getKey().toString();
    }

    public void setKey(Object key) {
	  this.key = key;
    }

    public String getValue() {
	  return this.value;
    }

    public void setValue(String value) {
	  this.value = value;
    }

    @Override
    public String toString() {
	  return this.value;
    }
}