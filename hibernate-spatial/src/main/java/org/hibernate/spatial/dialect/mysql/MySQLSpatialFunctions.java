package org.hibernate.spatial.dialect.mysql;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.spatial.JTSGeometryType;
import org.hibernate.type.StandardBasicTypes;

/**
 * @author Karel Maesen, Geovise BVBA
 *         creation-date: 9/15/12
 */
class MySQLSpatialFunctions implements Iterable<Map.Entry<String, StandardSQLFunction>> {

	final private Map<String, StandardSQLFunction> functionsToRegister = new HashMap<String, StandardSQLFunction>();

	MySQLSpatialFunctions(){
		functionsToRegister.put(
				"dimension", new StandardSQLFunction(
				"dimension",
				StandardBasicTypes.INTEGER
		)
		);
		functionsToRegister.put(
				"geometrytype", new StandardSQLFunction(
				"geometrytype", StandardBasicTypes.STRING
		)
		);
		functionsToRegister.put(
				"srid", new StandardSQLFunction(
				"srid",
				StandardBasicTypes.INTEGER
		)
		);
		functionsToRegister.put(
				"envelope", new StandardSQLFunction(
				"envelope",
				JTSGeometryType.INSTANCE
		)
		);
		functionsToRegister.put(
				"astext", new StandardSQLFunction(
				"astext",
				StandardBasicTypes.STRING
		)
		);
		functionsToRegister.put(
				"asbinary", new StandardSQLFunction(
				"asbinary",
				StandardBasicTypes.BINARY
		)
		);
		functionsToRegister.put(
				"isempty", new StandardSQLFunction(
				"isempty",
				StandardBasicTypes.BOOLEAN
		)
		);
		functionsToRegister.put(
				"issimple", new StandardSQLFunction(
				"issimple",
				StandardBasicTypes.BOOLEAN
		)
		);
		functionsToRegister.put(
				"boundary", new StandardSQLFunction(
				"boundary",
				JTSGeometryType.INSTANCE
		)
		);

		// Register functions for spatial relation constructs
		functionsToRegister.put(
				"overlaps", new StandardSQLFunction(
				"overlaps",
				StandardBasicTypes.BOOLEAN
		)
		);
		functionsToRegister.put(
				"intersects", new StandardSQLFunction(
				"intersects",
				StandardBasicTypes.BOOLEAN
		)
		);
		functionsToRegister.put(
				"equals", new StandardSQLFunction(
				"equals",
				StandardBasicTypes.BOOLEAN
		)
		);
		functionsToRegister.put(
				"contains", new StandardSQLFunction(
				"contains",
				StandardBasicTypes.BOOLEAN
		)
		);
		functionsToRegister.put(
				"crosses", new StandardSQLFunction(
				"crosses",
				StandardBasicTypes.BOOLEAN
		)
		);
		functionsToRegister.put(
				"disjoint", new StandardSQLFunction(
				"disjoint",
				StandardBasicTypes.BOOLEAN
		)
		);
		functionsToRegister.put(
				"touches", new StandardSQLFunction(
				"touches",
				StandardBasicTypes.BOOLEAN
		)
		);
		functionsToRegister.put(
				"within", new StandardSQLFunction(
				"within",
				StandardBasicTypes.BOOLEAN
		)
		);
		functionsToRegister.put(
				"relate", new StandardSQLFunction(
				"relate",
				StandardBasicTypes.BOOLEAN
		)
		);

		// register the spatial analysis functions
		functionsToRegister.put(
				"distance", new StandardSQLFunction(
				"distance",
				StandardBasicTypes.DOUBLE
		)
		);
		functionsToRegister.put(
				"buffer", new StandardSQLFunction(
				"buffer",
				JTSGeometryType.INSTANCE
		)
		);
		functionsToRegister.put(
				"convexhull", new StandardSQLFunction(
				"convexhull",
				JTSGeometryType.INSTANCE
		)
		);
		functionsToRegister.put(
				"difference", new StandardSQLFunction(
				"difference",
				JTSGeometryType.INSTANCE
		)
		);
		functionsToRegister.put(
				"intersection", new StandardSQLFunction(
				"intersection", JTSGeometryType.INSTANCE
		)
		);
		functionsToRegister.put(
				"symdifference", new StandardSQLFunction(
				"symdifference", JTSGeometryType.INSTANCE
		)
		);
		functionsToRegister.put(
				"geomunion", new StandardSQLFunction(
				"union",
				JTSGeometryType.INSTANCE
		)
		);
	}

	@Override
	public Iterator<Map.Entry<String, StandardSQLFunction>> iterator() {
		return functionsToRegister.entrySet().iterator();
	}
}
