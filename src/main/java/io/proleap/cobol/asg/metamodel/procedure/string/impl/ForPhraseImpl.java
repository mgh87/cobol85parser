/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.procedure.string.impl;

import io.proleap.cobol.Cobol85Parser.StringForPhraseContext;
import io.proleap.cobol.asg.metamodel.ProgramUnit;
import io.proleap.cobol.asg.metamodel.impl.CobolDivisionElementImpl;
import io.proleap.cobol.asg.metamodel.procedure.string.ForPhrase;
import io.proleap.cobol.asg.metamodel.valuestmt.ValueStmt;

public class ForPhraseImpl extends CobolDivisionElementImpl implements ForPhrase {

	protected final StringForPhraseContext ctx;

	protected ValueStmt forValueStmt;

	public ForPhraseImpl(final ProgramUnit programUnit, final StringForPhraseContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public ValueStmt getForValueStmt() {
		return forValueStmt;
	}

	@Override
	public void setForValueStmt(final ValueStmt forValueStmt) {
		this.forValueStmt = forValueStmt;
	}

}
