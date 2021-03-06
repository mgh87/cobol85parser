/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.procedure.write;

import io.proleap.cobol.Cobol85Parser.WriteAdvancingLinesContext;
import io.proleap.cobol.Cobol85Parser.WriteAdvancingMnemonicContext;
import io.proleap.cobol.asg.metamodel.CobolDivisionElement;

public interface AdvancingPhrase extends CobolDivisionElement {

	enum AdvancingType {
		LINES, MNEMONIC, PAGE
	}

	enum PositionType {
		AFTER, BEFORE
	}

	AdvancingLines addAdvancingLines(WriteAdvancingLinesContext ctx);

	AdvancingMnemonic addAdvancingMnemonic(WriteAdvancingMnemonicContext ctx);

	AdvancingLines getAdvancingLines();

	AdvancingMnemonic getAdvancingMnemonic();

	AdvancingType getAdvancingType();

	PositionType getPositionType();

	void setAdvancingType(AdvancingType advancingType);

	void setPositionType(PositionType positionType);
}
