package es.inf.uc3m.kr.vaskos.utils;

import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import es.weso.monads.Result;
import es.weso.rdfgraph.nodes.IRI;
import es.weso.shex.Typing;

public class Scala2Java {

	public static java.util.Map<IRI, java.util.Set<IRI>> convertRestultsToJava(Typing t){
		java.util.Map<IRI, java.util.Set<IRI>> converted = new java.util.HashMap<IRI, java.util.Set<IRI>>();
		java.util.Map<IRI, Set<IRI>> map = scala.collection.JavaConverters.asJavaMapConverter(t.map()).asJava();
		for(IRI key:map.keySet()){
			converted.put(key, scala.collection.JavaConverters.asJavaSetConverter(map.get(key)).asJava());
		}
		return converted;
	}
	
	public static java.util.List<java.util.Map<IRI, java.util.Set<IRI>>> convertRestultsToJava(Result<Typing> result){
		java.util.List<Typing> results = scala.collection.JavaConverters.asJavaListConverter(result.toList()).asJava();
		java.util.List<java.util.Map<IRI, java.util.Set<IRI>>> converted = new java.util.LinkedList<java.util.Map<IRI,java.util.Set<IRI>>>();
		for(Typing t:results){
			converted.add(convertRestultsToJava(t));
		}
		return converted;
	}
	
	public static java.util.List<java.util.Map<IRI, java.util.Set<IRI>>> convertRestultsToJava(Stream<Typing> result){
		java.util.List<Typing> results = scala.collection.JavaConverters.asJavaListConverter(result.toList()).asJava();
		java.util.List<java.util.Map<IRI, java.util.Set<IRI>>> converted = new java.util.LinkedList<java.util.Map<IRI,java.util.Set<IRI>>>();
		for(Typing t:results){
			converted.add(convertRestultsToJava(t));
		}
		return converted;
	}
}
