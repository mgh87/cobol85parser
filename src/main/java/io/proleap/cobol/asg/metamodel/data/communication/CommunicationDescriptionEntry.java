/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.data.communication;

import java.util.List;

import io.proleap.cobol.asg.metamodel.CobolDivisionElement;
import io.proleap.cobol.asg.metamodel.Declaration;
import io.proleap.cobol.asg.metamodel.call.CommunicationDescriptionEntryCall;

public interface CommunicationDescriptionEntry extends CobolDivisionElement, Declaration {

	enum CommunicationDescriptionEntryType {
		INPUT, INPUT_OUTPUT, OUTPUT
	}

	void addCall(CommunicationDescriptionEntryCall call);

	List<CommunicationDescriptionEntryCall> getCalls();

	CommunicationDescriptionEntryType getCommunicationDescriptionEntryType();
}
