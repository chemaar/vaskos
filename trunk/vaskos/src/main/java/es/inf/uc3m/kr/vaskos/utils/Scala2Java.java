package es.inf.uc3m.kr.vaskos.utils;

import java.util.Collection;
import java.util.HashSet;

import scala.Option;
import scala.collection.Iterable;
import scala.collection.immutable.Map;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import es.weso.monads.Result;
import es.weso.rdfgraph.nodes.IRI;
import es.weso.rdfgraph.nodes.RDFNode;
import es.weso.shex.Typing;

public class Scala2Java {

	public static java.util.Map<IRI, java.util.Set<IRI>> convertRestultsToJava(Typing t){
		java.util.Map<IRI, java.util.Set<IRI>> converted = new java.util.HashMap<IRI, java.util.Set<IRI>>();
		Map<RDFNode, Set<RDFNode>> map = t.map();
		Iterable<RDFNode> scalaKeys = map.keys();
		Collection<RDFNode> keys = scala.collection.JavaConverters.asJavaCollectionConverter(scalaKeys).asJavaCollection();
		for(RDFNode key:keys){
			Option<Set<RDFNode>> value = map.get(key);
			HashSet<RDFNode> rdfNodes = new HashSet<>(scala.collection.JavaConverters.asJavaCollectionConverter(value.get()).asJavaCollection());
			HashSet<IRI> iris = new HashSet<IRI>();
			for(RDFNode node:rdfNodes){
				iris.add(node.toIRI());
			}
			converted.put(key.toIRI(),iris);
		}
		return converted;
	}
	
	public static java.util.List<java.util.Map<IRI, java.util.Set<IRI>>> convertRestultsToJava(Result<Typing> result){
		java.util.Collection<Typing> results = scala.collection.JavaConverters.asJavaCollectionConverter(result.toList()).asJavaCollection();
		java.util.List<java.util.Map<IRI, java.util.Set<IRI>>> converted = new java.util.LinkedList<java.util.Map<IRI,java.util.Set<IRI>>>();
		for(Typing t:results){
			converted.add(convertRestultsToJava(t));
		}
		return converted;
	}
	
	public static java.util.List<java.util.Map<IRI, java.util.Set<IRI>>> convertRestultsToJava(Stream<Typing> result){
		java.util.Collection<Typing> results = scala.collection.JavaConverters.asJavaCollectionConverter(result.toList()).asJavaCollection();
		java.util.List<java.util.Map<IRI, java.util.Set<IRI>>> converted = new java.util.LinkedList<java.util.Map<IRI,java.util.Set<IRI>>>();
		for(Typing t:results){
			converted.add(convertRestultsToJava(t));
		}
		return converted;
	}
}
