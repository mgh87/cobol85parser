/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.environment.inputoutput.iocontrol;

import io.proleap.cobol.asg.metamodel.CobolDivisionElement;
import io.proleap.cobol.asg.metamodel.call.Call;
import io.proleap.cobol.asg.metamodel.valuestmt.IntegerLiteralValueStmt;

public interface MultipleFilePosition extends CobolDivisionElement {

	Call getFileCall();

	IntegerLiteralValueStmt getIntegerLiteralValueStmt();

	void setFileCall(Call fileCall);

	void setIntegerLiteralValueStmt(IntegerLiteralValueStmt integerLiteralValueStmt);
}
