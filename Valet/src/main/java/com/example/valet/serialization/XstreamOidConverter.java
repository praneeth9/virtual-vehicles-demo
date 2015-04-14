package com.example.valet.serialization;

import org.bson.types.ObjectId;

import com.strategicgains.repoexpress.mongodb.Identifiers;
import com.thoughtworks.xstream.converters.SingleValueConverter;

/**
 * @author toddf
 * @since Feb 16, 2011
 */
public class XstreamOidConverter
        implements SingleValueConverter {

    @SuppressWarnings("rawtypes")
    @Override
    public boolean canConvert(Class aClass) {
        return ObjectId.class.isAssignableFrom(aClass);
    }

    @Override
    public Object fromString(String value) {
        return (ObjectId) Identifiers.MONGOID.parse(value).primaryKey();
    }

    @Override
    public String toString(Object objectId) {
        return ((ObjectId) objectId).toString();
    }
}
