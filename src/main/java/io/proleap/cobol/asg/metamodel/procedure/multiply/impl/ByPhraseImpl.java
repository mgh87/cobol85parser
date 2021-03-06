/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.procedure.multiply.impl;

import java.util.ArrayList;
import java.util.List;

import io.proleap.cobol.Cobol85Parser.MultiplyRegularContext;
import io.proleap.cobol.Cobol85Parser.MultiplyRegularOperandContext;
import io.proleap.cobol.asg.metamodel.ProgramUnit;
import io.proleap.cobol.asg.metamodel.call.Call;
import io.proleap.cobol.asg.metamodel.impl.CobolDivisionElementImpl;
import io.proleap.cobol.asg.metamodel.procedure.multiply.ByPhrase;
import io.proleap.cobol.asg.metamodel.procedure.multiply.ByOperand;

public class ByPhraseImpl extends CobolDivisionElementImpl implements ByPhrase {

	protected final MultiplyRegularContext ctx;

	protected List<ByOperand> byOperands = new ArrayList<ByOperand>();

	public ByPhraseImpl(final ProgramUnit programUnit, final MultiplyRegularContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public ByOperand addOperand(final MultiplyRegularOperandContext ctx) {
		ByOperand result = (ByOperand) getASGElement(ctx);

		if (result == null) {
			result = new ByOperandImpl(programUnit, ctx);

			// call
			final Call operandCall = createCall(ctx.identifier());
			result.setOperandCall(operandCall);

			// rounded
			if (ctx.ROUNDED() != null) {
				result.setRounded(true);
			}

			byOperands.add(result);
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public List<ByOperand> getByOperands() {
		return byOperands;
	}

}
