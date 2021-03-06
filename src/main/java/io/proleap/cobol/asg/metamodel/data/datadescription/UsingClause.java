/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.data.datadescription;

import io.proleap.cobol.asg.metamodel.CobolDivisionElement;
import io.proleap.cobol.asg.metamodel.valuestmt.ValueStmt;

public interface UsingClause extends CobolDivisionElement {

	enum UsingClauseType {
		CONVENTION, LANGUAGE
	}

	ValueStmt getOfValueStmt();

	UsingClauseType getUsingClauseType();

	void setOfValueStmt(ValueStmt ofValueStmt);

	void setUsingClauseType(UsingClauseType usingClauseType);
}
