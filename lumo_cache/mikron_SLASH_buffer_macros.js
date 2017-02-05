goog.provide("mikron.buffer_macros");
/**
 * Executes `body` and updates the position `pos` with the delta `delta`.
 */
mikron.buffer_macros.with_delta = (function mikron$buffer_macros$with_delta(_AMPERSAND_form,_AMPERSAND_env,pos,delta,body){
var value = cljs.core.with_meta.call(null,cljs.core.gensym.call(null,"value"),new cljs.core.PersistentArrayMap(null, 5, [new cljs.core.Keyword(null,"file","file",(-1269645878)),mikron.buffer_macros,new cljs.core.Keyword(null,"line","line",(212345235)),(8),new cljs.core.Keyword(null,"column","column",(2078222095)),(31),new cljs.core.Keyword(null,"end-line","end-line",(1837326455)),(8),new cljs.core.Keyword(null,"end-column","end-column",(1425389514)),(36)], null));
return cljs.core.sequence.call(null,cljs.core.concat.call(null,cljs.core._conj.call(null,cljs.core.List.EMPTY,new cljs.core.Symbol("cljs.core","let","cljs.core/let",(-308701135),null)),(function (){var x__25689__auto__ = cljs.core.vec.call(null,cljs.core.sequence.call(null,cljs.core.concat.call(null,(function (){var x__25689__auto__ = value;
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})(),(function (){var x__25689__auto__ = body;
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})())));
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})(),(function (){var x__25689__auto__ = cljs.core.sequence.call(null,cljs.core.concat.call(null,cljs.core._conj.call(null,cljs.core.List.EMPTY,new cljs.core.Symbol(null,"set!","set!",(250714521),null)),(function (){var x__25689__auto__ = pos;
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})(),(function (){var x__25689__auto__ = cljs.core.sequence.call(null,cljs.core.concat.call(null,cljs.core._conj.call(null,cljs.core.List.EMPTY,new cljs.core.Symbol("cljs.core","unchecked-add","cljs.core/unchecked-add",(1865931960),null)),(function (){var x__25689__auto__ = pos;
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})(),(function (){var x__25689__auto__ = delta;
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})()));
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})()));
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})(),(function (){var x__25689__auto__ = value;
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})()));
});

mikron.buffer_macros.with_delta.cljs$lang$macro = true;
/**
 * Executes the expressions with the endianness automatically set to `le`.
 */
mikron.buffer_macros.with_le = (function mikron$buffer_macros$with_le(_AMPERSAND_form,_AMPERSAND_env,le,p__216){
var vec__220 = p__216;
var seq__221 = cljs.core.seq.call(null,vec__220);
var first__222 = cljs.core.first.call(null,seq__221);
var seq__221__$1 = cljs.core.next.call(null,seq__221);
var expr = first__222;
var exprs = seq__221__$1;
return cljs.core.sequence.call(null,cljs.core.concat.call(null,cljs.core._conj.call(null,cljs.core.List.EMPTY,new cljs.core.Symbol(null,"if","if",(1181717262),null)),(function (){var x__25689__auto__ = le;
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})(),(function (){var x__25689__auto__ = cljs.core.sequence.call(null,cljs.core.concat.call(null,(function (){var x__25689__auto__ = cljs.core.symbol.call(null,[cljs.core.str.cljs$core$IFn$_invoke$arity$1(expr),cljs.core.str.cljs$core$IFn$_invoke$arity$1("LE")].join(''));
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})(),exprs));
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})(),(function (){var x__25689__auto__ = cljs.core.sequence.call(null,cljs.core.concat.call(null,(function (){var x__25689__auto__ = cljs.core.symbol.call(null,[cljs.core.str.cljs$core$IFn$_invoke$arity$1(expr),cljs.core.str.cljs$core$IFn$_invoke$arity$1("BE")].join(''));
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})(),exprs));
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})()));
});

mikron.buffer_macros.with_le.cljs$lang$macro = true;
/**
 * Expands to a `definterface` call in clj, `defprotocol` call in cljs.
 */
mikron.buffer_macros.definterface_PLUS_ = (function mikron$buffer_macros$definterface_PLUS_(var_args){
var args__25948__auto__ = [];
var len__25946__auto___239 = arguments.length;
var i__25947__auto___240 = (0);
while(true){
if((i__25947__auto___240 < len__25946__auto___239)){
args__25948__auto__.push((arguments[i__25947__auto___240]));

var G__241 = (i__25947__auto___240 + (1));
i__25947__auto___240 = G__241;
continue;
} else {
}
break;
}

var argseq__25949__auto__ = ((((3) < args__25948__auto__.length))?(new cljs.core.IndexedSeq(args__25948__auto__.slice((3)),(0),null)):null);
return mikron.buffer_macros.definterface_PLUS_.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),(arguments[(1)]),(arguments[(2)]),argseq__25949__auto__);
});

mikron.buffer_macros.definterface_PLUS_.cljs$core$IFn$_invoke$arity$variadic = (function (_AMPERSAND_form,_AMPERSAND_env,name,ops){
var no_meta = (function (p1__7_SHARP_){
return cljs.core.with_meta.call(null,p1__7_SHARP_,null);
});
var cljs_QMARK_ = cljs.core.boolean$.call(null,new cljs.core.Keyword(null,"ns","ns",(441598760)).cljs$core$IFn$_invoke$arity$1(_AMPERSAND_env));
var ops__$1 = cljs.core.map.call(null,((function (no_meta,cljs_QMARK_){
return (function (p__227){
var vec__228 = p__227;
var op_name = cljs.core.nth.call(null,vec__228,(0),null);
var args = cljs.core.nth.call(null,vec__228,(1),null);
var doc_string = cljs.core.nth.call(null,vec__228,(2),null);
return new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [op_name,args,cljs.core.vec.call(null,cljs.core.cons.call(null,new cljs.core.Symbol(null,"this","this",(1028897902),null),cljs.core.map.call(null,no_meta,args))),(cljs.core.truth_(doc_string)?new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [doc_string], null):null)], null);
});})(no_meta,cljs_QMARK_))
,ops);
var inner_form = cljs.core.sequence.call(null,cljs.core.concat.call(null,(function (){var x__25689__auto__ = ((cljs_QMARK_)?new cljs.core.Symbol("cljs.core","defprotocol","cljs.core/defprotocol",(1787210635),null):new cljs.core.Symbol("mikron.buffer-macros","definterface","mikron.buffer-macros/definterface",(-1437711677),null));
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})(),(function (){var x__25689__auto__ = name;
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})(),cljs.core.map.call(null,((function (no_meta,cljs_QMARK_,ops__$1){
return (function (p__231){
var vec__232 = p__231;
var op_name = cljs.core.nth.call(null,vec__232,(0),null);
var args = cljs.core.nth.call(null,vec__232,(1),null);
var args_SINGLEQUOTE_ = cljs.core.nth.call(null,vec__232,(2),null);
var doc_string = cljs.core.nth.call(null,vec__232,(3),null);
if(cljs_QMARK_){
return cljs.core.sequence.call(null,cljs.core.concat.call(null,(function (){var x__25689__auto__ = no_meta.call(null,op_name);
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})(),(function (){var x__25689__auto__ = args_SINGLEQUOTE_;
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})(),doc_string));
} else {
return cljs.core.sequence.call(null,cljs.core.concat.call(null,(function (){var x__25689__auto__ = cljs.core.with_meta.call(null,cljs.core.munge.call(null,op_name),cljs.core.meta.call(null,op_name));
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})(),(function (){var x__25689__auto__ = args;
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})(),doc_string));
}
});})(no_meta,cljs_QMARK_,ops__$1))
,ops__$1)));
if(cljs_QMARK_){
return inner_form;
} else {
return cljs.core.sequence.call(null,cljs.core.concat.call(null,cljs.core._conj.call(null,cljs.core.List.EMPTY,new cljs.core.Symbol(null,"do","do",(1686842252),null)),(function (){var x__25689__auto__ = inner_form;
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})(),cljs.core.map.call(null,((function (no_meta,cljs_QMARK_,ops__$1,inner_form){
return (function (p__235){
var vec__236 = p__235;
var op_name = cljs.core.nth.call(null,vec__236,(0),null);
var args = cljs.core.nth.call(null,vec__236,(1),null);
var args_SINGLEQUOTE_ = cljs.core.nth.call(null,vec__236,(2),null);
var doc_string = cljs.core.nth.call(null,vec__236,(3),null);
return cljs.core.sequence.call(null,cljs.core.concat.call(null,cljs.core._conj.call(null,cljs.core.List.EMPTY,new cljs.core.Symbol("cljs.core","defn","cljs.core/defn",(-1606493717),null)),(function (){var x__25689__auto__ = no_meta.call(null,op_name);
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})(),(function (){var x__25689__auto__ = cljs.core.apply.call(null,cljs.core.array_map,cljs.core.sequence.call(null,cljs.core.concat.call(null,cljs.core._conj.call(null,cljs.core.List.EMPTY,new cljs.core.Keyword(null,"inline","inline",(1399884222))),(function (){var x__25689__auto__ = cljs.core.sequence.call(null,cljs.core.concat.call(null,cljs.core._conj.call(null,cljs.core.List.EMPTY,new cljs.core.Symbol("cljs.core","fn","cljs.core/fn",(-1065745098),null)),(function (){var x__25689__auto__ = args_SINGLEQUOTE_;
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})(),(function (){var x__25689__auto__ = cljs.core.sequence.call(null,cljs.core.concat.call(null,cljs.core._conj.call(null,cljs.core.List.EMPTY,new cljs.core.Symbol("cljs.core","sequence","cljs.core/sequence",(1908459032),null)),(function (){var x__25689__auto__ = cljs.core.sequence.call(null,cljs.core.concat.call(null,cljs.core._conj.call(null,cljs.core.List.EMPTY,new cljs.core.Symbol("cljs.core","concat","cljs.core/concat",(-1133584918),null)),(function (){var x__25689__auto__ = cljs.core.sequence.call(null,cljs.core.concat.call(null,cljs.core._conj.call(null,cljs.core.List.EMPTY,new cljs.core.Symbol("cljs.core","list","cljs.core/list",(-1331406371),null)),(function (){var x__25689__auto__ = cljs.core.sequence.call(null,cljs.core.concat.call(null,cljs.core._conj.call(null,cljs.core.List.EMPTY,new cljs.core.Symbol(null,"quote","quote",(1377916282),null)),(function (){var x__25689__auto__ = cljs.core.symbol.call(null,[cljs.core.str.cljs$core$IFn$_invoke$arity$1("."),cljs.core.str.cljs$core$IFn$_invoke$arity$1(cljs.core.munge.call(null,op_name))].join(''));
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})()));
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})()));
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})(),(function (){var x__25689__auto__ = cljs.core.sequence.call(null,cljs.core.concat.call(null,cljs.core._conj.call(null,cljs.core.List.EMPTY,new cljs.core.Symbol("cljs.core","list","cljs.core/list",(-1331406371),null)),args_SINGLEQUOTE_));
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})()));
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})()));
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})()));
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})())));
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})(),(function (){var x__25689__auto__ = cljs.core.with_meta.call(null,cljs.core.vec.call(null,cljs.core.cons.call(null,cljs.core.with_meta.call(null,new cljs.core.Symbol(null,"this","this",(1028897902),null),new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"tag","tag",(-1290361223)),name], null)),args)),cljs.core.meta.call(null,op_name));
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})(),(function (){var x__25689__auto__ = cljs.core.sequence.call(null,cljs.core.concat.call(null,(function (){var x__25689__auto__ = cljs.core.symbol.call(null,[cljs.core.str.cljs$core$IFn$_invoke$arity$1("."),cljs.core.str.cljs$core$IFn$_invoke$arity$1(cljs.core.munge.call(null,op_name))].join(''));
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})(),args_SINGLEQUOTE_));
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__25689__auto__);
})()));
});})(no_meta,cljs_QMARK_,ops__$1,inner_form))
,ops__$1)));
}
});

mikron.buffer_macros.definterface_PLUS_.cljs$lang$maxFixedArity = (3);

mikron.buffer_macros.definterface_PLUS_.cljs$lang$applyTo = (function (seq223){
var G__224 = cljs.core.first.call(null,seq223);
var seq223__$1 = cljs.core.next.call(null,seq223);
var G__225 = cljs.core.first.call(null,seq223__$1);
var seq223__$2 = cljs.core.next.call(null,seq223__$1);
var G__226 = cljs.core.first.call(null,seq223__$2);
var seq223__$3 = cljs.core.next.call(null,seq223__$2);
return mikron.buffer_macros.definterface_PLUS_.cljs$core$IFn$_invoke$arity$variadic(G__224,G__225,G__226,seq223__$3);
});


mikron.buffer_macros.definterface_PLUS_.cljs$lang$macro = true;
