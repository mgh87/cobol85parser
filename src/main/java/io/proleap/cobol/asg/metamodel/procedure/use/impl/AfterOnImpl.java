/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.procedure.use.impl;

import java.util.ArrayList;
import java.util.List;

import io.proleap.cobol.Cobol85Parser.UseAfterOnContext;
import io.proleap.cobol.asg.metamodel.ProgramUnit;
import io.proleap.cobol.asg.metamodel.call.Call;
import io.proleap.cobol.asg.metamodel.impl.CobolDivisionElementImpl;
import io.proleap.cobol.asg.metamodel.procedure.use.AfterOn;

public class AfterOnImpl extends CobolDivisionElementImpl implements AfterOn {

	protected AfterOnType afterOnType;

	protected UseAfterOnContext ctx;

	protected List<Call> fileCalls = new ArrayList<Call>();

	public AfterOnImpl(final ProgramUnit programUnit, final UseAfterOnContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public void addFileCall(final Call fileCall) {
		fileCalls.add(fileCall);
	}

	@Override
	public AfterOnType getAfterOnType() {
		return afterOnType;
	}

	@Override
	public List<Call> getFileCalls() {
		return fileCalls;
	}

	@Override
	public void setType(final AfterOnType afterOnType) {
		this.afterOnType = afterOnType;
	}

}
