package com.wejo.consent.sandbox.azure.servicebus;

import java.io.Serializable;
import java.util.Objects;

public class DataPoint implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String dataId;
	private String datetimeStamp;
	private String dataValue;
	
	
	public DataPoint(String dataId, String datetimeStamp, String dataValue) {
		super();
		this.dataId = dataId;
		this.datetimeStamp = datetimeStamp;
		this.dataValue = dataValue;
	}


	
	@Override
	public int hashCode() {
		return Objects.hash(dataId, dataValue, datetimeStamp);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataPoint other = (DataPoint) obj;
		return Objects.equals(dataId, other.dataId) && Objects.equals(dataValue, other.dataValue)
				&& Objects.equals(datetimeStamp, other.datetimeStamp);
	}



	public String getDataId() {
		return dataId;
	}



	public String getDatetimeStamp() {
		return datetimeStamp;
	}



	public String getDataValue() {
		return dataValue;
	}



	@Override
	public String toString() {
		return "DataPoint [dataId=" + dataId + ", datetimeStamp=" + datetimeStamp + ", dataValue=" + dataValue + "]";
	}
	
	
}
