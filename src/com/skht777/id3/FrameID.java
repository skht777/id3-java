/**
 * 
 */
package com.skht777.id3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author skht777
 *
 */
public enum FrameID {

	AENC,
	APIC,
	ASPI,
	BUF,
	CNT,
	COM,
	COMM,
	COMR,
	CRA,
	CRM,
	ENCR,
	EQU,
	EQU2,
	EQUA,
	ETC,
	ETCO,
	GEO,
	GEOB,
	GRID,
	IPL,
	IPLS,
	LINK,
	LNK,
	MCDI,
	MCI,
	MLL,
	MLLT,
	OWNE,
	PCNT,
	PIC,
	POP,
	POPM,
	POSS,
	PRIV,
	RBUF,
	REV,
	RVA,
	RVA2,
	RVAD,
	RVRB,
	SEEK,
	SIGN,
	SLT,
	STC,
	SYLT,
	SYTC,
	TAL,
	TALB,
	TBP,
	TBPM,
	TCM,
	TCO,
	TCOM,
	TCON,
	TCOP,
	TCR,
	TDA,
	TDAT,
	TDEN,
	TDLY,
	TDOR,
	TDRC,
	TDRL,
	TDTG,
	TDY,
	TEN,
	TENC,
	TEXT,
	TFLT,
	TFT,
	TIM,
	TIME,
	TIPL,
	TIT1,
	TIT2,
	TIT3,
	TKE,
	TKEY,
	TLA,
	TLAN,
	TLE,
	TLEN,
	TMCL,
	TMED,
	TMOO,
	TMT,
	TOA,
	TOAL,
	TOF,
	TOFN,
	TOL,
	TOLY,
	TOPE,
	TOR,
	TORY,
	TOT,
	TOWN,
	TP1,
	TP2,
	TP3,
	TP4,
	TPA,
	TPB,
	TPE1,
	TPE2,
	TPE3,
	TPE4,
	TPOS,
	TPRO,
	TPUB,
	TRC,
	TRCK,
	TRD,
	TRDA,
	TRK,
	TRSN,
	TRSO,
	TSI,
	TSIZ,
	TSOA,
	TSOP,
	TSOT,
	TSRC,
	TSS,
	TSSE,
	TSST,
	TT1,
	TT2,
	TT3,
	TXT,
	TXX,
	TXXX,
	TYE,
	TYER,
	UFI,
	UFID,
	ULT,
	USER,
	USLT,
	WAF,
	WAR,
	WAS,
	WCM,
	WCOM,
	WCOP,
	WCP,
	WOAF,
	WOAR,
	WOAS,
	WORS,
	WPAY,
	WPB,
	WPUB,
	WXX,
	WXXX,
	// extends
	ITNU,
	ITU,
	PCS,
	PCST,
	TCAT,
	TCMP,
	TCP,
	TDES,
	TGID,
	TKWD,
	TS2,
	TSA,
	TSC,
	TSO2,
	TSOC,
	TSP,
	TST,
	WFED,
	XDOR,
	XOLY,
	XSOA,
	XSOP,
	XSOT;
	
	private enum Conversion {
		
		COVERT_AENC(CRA, AENC, AENC),
		COVERT_APIC(PIC, APIC, APIC),
		COVERT_ASPI(null, null, ASPI),
		COVERT_COMM(COM, COMM, COMM),
		COVERT_COMR(null, COMR, COMR),
		COVERT_ENCR(null, ENCR, ENCR),
		COVERT_EQUA(EQU, EQUA, EQU2),
		COVERT_ETCO(ETC, ETCO, ETCO),
		COVERT_GEOB(GEO, GEOB, GEOB),
		COVERT_GRID(null, GRID, GRID),
		COVERT_LINK(LNK, LINK, LINK),
		COVERT_MCDI(MCI, MCDI, MCDI),
		COVERT_MLLT(MLL, MLLT, MLLT),
		COVERT_CRM(CRM, null, null),
		COVERT_TSIZ(TSI, TSIZ, null),
		COVERT_OWNE(null, OWNE, OWNE),
		COVERT_PRIV(null, PRIV, PCNT),
		COVERT_PCNT(CNT, PCNT, POPM),
		COVERT_POPM(POP, POPM, POSS),
		COVERT_POSS(null, POSS, PRIV),
		COVERT_RBUF(BUF, RBUF, RBUF),
		COVERT_RVAD(RVA, RVAD, RVA2),
		COVERT_RVRB(REV, RVRB, RVRB),
		COVERT_SEEK(null, null, SEEK),
		COVERT_SIGN(null, null, SIGN),
		COVERT_SYLT(STC, SYLT, SYLT),
		COVERT_SYTC(SLT, SYTC, SYTC),
		COVERT_TALB(TAL, TALB, TALB),
		COVERT_TBPM(TBP, TBPM, TBPM),
		COVERT_TCOM(TCM, TCOM, TCOM),
		COVERT_TCON(TCO, TCON, TCON),
		COVERT_TCOP(TCR, TCOP, TCOP),
		COVERT_TDEN(null, null, TDEN),
		COVERT_TDLY(TDY, TDLY, TDLY),
		COVERT_TDOR(null, null, TDOR),
		COVERT_TDRC(null, null, TDRC),
		COVERT_TDAT(TDA, TDAT, TDRC),
		COVERT_TIME(TIM, TIME, TDRC),
		COVERT_TORY(TOR, TORY, TDRC),
		COVERT_TRDA(TRD, TRDA, TDRC),
		COVERT_TYER(TYE, TYER, TDRC),
		COVERT_TDRL(null, null, TDRL),
		COVERT_TDTG(null, null, TDTG),
		COVERT_TENC(TEN, TENC, TENC),
		COVERT_TEXT(TXT, TEXT, TEXT),
		COVERT_TFLT(TFT, TFLT, TFLT),
		COVERT_IPLS(IPL, IPLS, TIPL),
		COVERT_TIT1(TT1, TIT1, TIT1),
		COVERT_TIT2(TT2, TIT2, TIT2),
		COVERT_TIT3(TT3, TIT3, TIT3),
		COVERT_TKEY(TKE, TKEY, TKEY),
		COVERT_TLAN(TLA, TLAN, TLAN),
		COVERT_TLEN(TLE, TLEN, TLEN),
		COVERT_TMCL(null, null, TMCL),
		COVERT_TMED(TMT, TMED, TMED),
		COVERT_TMOO(null, null, TMOO),
		COVERT_TOAL(TOT, TOAL, TOAL),
		COVERT_TOFN(TOF, TOFN, TOFN),
		COVERT_TOLY(TOL, TOLY, TOLY),
		COVERT_TOPE(TOA, TOPE, TOPE),
		COVERT_TOWN(null, TOWN, TOWN),
		COVERT_TPE1(TP1, TPE1, TPE1),
		COVERT_TPE2(TP2, TPE2, TPE2),
		COVERT_TPE3(TP3, TPE3, TPE3),
		COVERT_TPE4(TP4, TPE4, TPE4),
		COVERT_TPOS(TPA, TPOS, TPOS),
		COVERT_TPRO(null, null, TPRO),
		COVERT_TPUB(TPB, TPUB, TPUB),
		COVERT_TRCK(TRK, TRCK, TRCK),
		COVERT_TRSN(null, TRSN, TRSN),
		COVERT_TRSO(null, TRSO, TRSO),
		COVERT_TSOA(null, null, TSOA),
		COVERT_TSOP(null, null, TSOP),
		COVERT_TSOT(null, null, TSOT),
		COVERT_TSRC(TRC, TSRC, TSRC),
		COVERT_TSSE(TSS, TSSE, TSSE),
		COVERT_TSST(null, null, TSST),
		COVERT_TXXX(TXX, TXXX, TXXX),
		COVERT_UFID(UFI, UFID, UFID),
		COVERT_USER(null, USER, USER),
		COVERT_USLT(ULT, USLT, USLT),
		COVERT_WCOM(WCM, WCOM, WCOM),
		COVERT_WCOP(WCP, WCOP, WCOP),
		COVERT_WOAF(WAF, WOAF, WOAF),
		COVERT_WOAR(WAR, WOAR, WOAR),
		COVERT_WOAS(WAS, WOAS, WOAS),
		COVERT_WORS(null, WORS, WORS),
		COVERT_WPAY(null, WPAY, WPAY),
		COVERT_WPUB(WPB, WPUB, WPUB),
		COVERT_WXXX(WXX, WXXX, WXXX),
		// extends
		COVERT_ITNU(ITU, ITNU, ITNU),
		COVERT_PCST(PCS, PCST, PCST),
		COVERT_TCAT(null, TCAT, TCAT),
		COVERT_TCMP(TCP, TCMP, TCMP),
		COVERT_TDES(null, TDES, TDES),
		COVERT_TGID(null, TGID, TGID),
		COVERT_TKWD(null, TKWD, TKWD),
		COVERT_TSO2(TS2, TSO2, TSO2),
		COVERT_TSOC(TSC, TSOC, TSOC),
		COVERT_WFED(null, WFED, WFED),
		COVERT_XDOR(null, XDOR, XDOR),
		COVERT_XOLY(null, XOLY, XOLY),
		COVERT_XSOA(TSA, XSOA, XSOA),
		COVERT_XSOP(TSP, XSOP, XSOP),
		COVERT_XSOT(TST, XSOT, XSOT);
		
		private Map<ID3Version, FrameID> map;
		
		private Conversion(FrameID v22, FrameID v23, FrameID v24) {
			map = new HashMap<>();
			map.put(ID3Version.V22, v22);
			map.put(ID3Version.V23, v23);
			map.put(ID3Version.V24, v24);
		}
		
		private static Conversion getConversion(FrameID id) {
			return Arrays.stream(Conversion.values())
					.filter(c -> c.map.values().contains(id))
					.findFirst().get();
		}
		
		private FrameID get(ID3Version ver) {
			return map.get(ver);
		}
		
	}
	
	public static List<FrameID> getEnableID(ID3Version ver) {
		return Arrays.stream(FrameID.values()).map(fid -> fid.convert(ver))
				.filter(fid -> fid != null).distinct()
				.sorted()
				.collect(Collectors.toList());
	}
	
	public FrameID convert(ID3Version ver) {
		return Conversion.getConversion(this).get(ver);
	}
	
}
