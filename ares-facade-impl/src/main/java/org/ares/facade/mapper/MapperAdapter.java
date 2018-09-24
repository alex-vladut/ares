package org.ares.facade.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;

public class MapperAdapter {

    private final Mapper mapper;

    public MapperAdapter(final Mapper mapper) {
	this.mapper = mapper;
    }

    public <T> T map(final Object source, final Class<T> destinationClass) {
	if (source == null) {
	    return null;
	}
	return this.mapper.map(source, destinationClass);
    }

    public <T> List<T> map(final List<Object> sourceList, final Class<T> destinationClass) {
	final List<T> result = new ArrayList<T>();
	if (sourceList != null && !sourceList.isEmpty()) {
	    for (final Object source : sourceList) {
		result.add(map(source, destinationClass));
	    }
	}
	return result;
    }
}
