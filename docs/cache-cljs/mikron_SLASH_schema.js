goog.provide("mikron.schema");
/**
 * The default built-in aliased types.
 */
(function (){
mikron.schema.aliases = new cljs.core.PersistentArrayMap(null, 5, [new cljs.core.Keyword(null,"char","char",(-641587586)),new cljs.core.PersistentVector(null, 5, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"wrapped","wrapped",(1775172701)),cljs.core.PersistentArrayMap.EMPTY,new cljs.core.Symbol("mikron.util.schema","char->int","mikron.util.schema/char->int",(697791125),null),new cljs.core.Symbol("mikron.util.schema","int->char","mikron.util.schema/int->char",(-216355484),null),new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"int","int",(-1741416922))], null)], null),new cljs.core.Keyword(null,"string","string",(-1989541586)),new cljs.core.PersistentVector(null, 5, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"wrapped","wrapped",(1775172701)),cljs.core.PersistentArrayMap.EMPTY,new cljs.core.Symbol("mikron.util.schema","string->binary","mikron.util.schema/string->binary",(-444913317),null),new cljs.core.Symbol("mikron.util.schema","binary->string","mikron.util.schema/binary->string",(-714021430),null),new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"binary","binary",(-1802232288))], null)], null),new cljs.core.Keyword(null,"keyword","keyword",(811389747)),new cljs.core.PersistentVector(null, 5, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"wrapped","wrapped",(1775172701)),cljs.core.PersistentArrayMap.EMPTY,new cljs.core.Symbol("mikron.util.schema","keyword->string","mikron.util.schema/keyword->string",(1495241845),null),new cljs.core.Symbol("mikron.util.schema","string->keyword","mikron.util.schema/string->keyword",(-15543812),null),new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"string","string",(-1989541586))], null)], null),new cljs.core.Keyword(null,"symbol","symbol",(-1038572696)),new cljs.core.PersistentVector(null, 5, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"wrapped","wrapped",(1775172701)),cljs.core.PersistentArrayMap.EMPTY,new cljs.core.Symbol("cljs.core","str","cljs.core/str",(-1971828991),null),new cljs.core.Symbol("cljs.core","symbol","cljs.core/symbol",(195265748),null),new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"string","string",(-1989541586))], null)], null),new cljs.core.Keyword(null,"any","any",(1705907423)),new cljs.core.PersistentVector(null, 5, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"wrapped","wrapped",(1775172701)),cljs.core.PersistentArrayMap.EMPTY,new cljs.core.Symbol("mikron.util.schema","any->string","mikron.util.schema/any->string",(-1063285825),null),new cljs.core.Symbol("mikron.util.schema","string->any","mikron.util.schema/string->any",(-1040075661),null),new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"string","string",(-1989541586))], null)], null)], null); return (
new cljs.core.Var(function(){return mikron.schema.aliases;},new cljs.core.Symbol("mikron.schema","aliases","mikron.schema/aliases",(-1057931374),null),cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"ns","ns",(441598760)),new cljs.core.Keyword(null,"name","name",(1843675177)),new cljs.core.Keyword(null,"file","file",(-1269645878)),new cljs.core.Keyword(null,"end-column","end-column",(1425389514)),new cljs.core.Keyword(null,"column","column",(2078222095)),new cljs.core.Keyword(null,"line","line",(212345235)),new cljs.core.Keyword(null,"end-line","end-line",(1837326455)),new cljs.core.Keyword(null,"arglists","arglists",(1661989754)),new cljs.core.Keyword(null,"doc","doc",(1913296891)),new cljs.core.Keyword(null,"test","test",(577538877))],[new cljs.core.Symbol(null,"mikron.schema","mikron.schema",(1753517621),null),new cljs.core.Symbol(null,"aliases","aliases",(-1307561055),null),"mikron/schema.cljc",(13),(1),(5),(5),cljs.core.List.EMPTY,"The default built-in aliased types.",(cljs.core.truth_(mikron.schema.aliases)?mikron.schema.aliases.cljs$lang$test:null)])));})()
;
/**
 * Returns a new hierarchy in which all `children` derive from `parent`, using
 *   `hierarchy` as the base.
 */
(function (){
mikron.schema.derives = (function mikron$schema$derives(hierarchy,parent,children){
return cljs.core.reduce.call(null,(function (p1__1_SHARP_,p2__2_SHARP_){
return cljs.core.derive.call(null,p1__1_SHARP_,p2__2_SHARP_,parent);
}),hierarchy,children);
}); return (
new cljs.core.Var(function(){return mikron.schema.derives;},new cljs.core.Symbol("mikron.schema","derives","mikron.schema/derives",(-999592729),null),cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"ns","ns",(441598760)),new cljs.core.Keyword(null,"name","name",(1843675177)),new cljs.core.Keyword(null,"file","file",(-1269645878)),new cljs.core.Keyword(null,"end-column","end-column",(1425389514)),new cljs.core.Keyword(null,"column","column",(2078222095)),new cljs.core.Keyword(null,"line","line",(212345235)),new cljs.core.Keyword(null,"end-line","end-line",(1837326455)),new cljs.core.Keyword(null,"arglists","arglists",(1661989754)),new cljs.core.Keyword(null,"doc","doc",(1913296891)),new cljs.core.Keyword(null,"test","test",(577538877))],[new cljs.core.Symbol(null,"mikron.schema","mikron.schema",(1753517621),null),new cljs.core.Symbol(null,"derives","derives",(-158723948),null),"mikron/schema.cljc",(14),(1),(13),(13),cljs.core.list(new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Symbol(null,"hierarchy","hierarchy",(587061186),null),new cljs.core.Symbol(null,"parent","parent",(761652748),null),new cljs.core.Symbol(null,"children","children",(699969545),null)], null)),"Returns a new hierarchy in which all `children` derive from `parent`, using\n  `hierarchy` as the base.",(cljs.core.truth_(mikron.schema.derives)?mikron.schema.derives.cljs$lang$test:null)])));})()
;
/**
 * Converts a graph to a hierarchy.
 */
(function (){
mikron.schema.graph__GT_hierarchy = (function mikron$schema$graph__GT_hierarchy(graph){
return cljs.core.reduce.call(null,(function (hierarchy,p__29){
var vec__30 = p__29;
var parent = cljs.core.nth.call(null,vec__30,(0),null);
var children = cljs.core.nth.call(null,vec__30,(1),null);
return mikron.schema.derives.call(null,hierarchy,parent,children);
}),cljs.core.make_hierarchy.call(null),graph);
}); return (
new cljs.core.Var(function(){return mikron.schema.graph__GT_hierarchy;},new cljs.core.Symbol("mikron.schema","graph->hierarchy","mikron.schema/graph->hierarchy",(58427501),null),cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"ns","ns",(441598760)),new cljs.core.Keyword(null,"name","name",(1843675177)),new cljs.core.Keyword(null,"file","file",(-1269645878)),new cljs.core.Keyword(null,"end-column","end-column",(1425389514)),new cljs.core.Keyword(null,"column","column",(2078222095)),new cljs.core.Keyword(null,"line","line",(212345235)),new cljs.core.Keyword(null,"end-line","end-line",(1837326455)),new cljs.core.Keyword(null,"arglists","arglists",(1661989754)),new cljs.core.Keyword(null,"doc","doc",(1913296891)),new cljs.core.Keyword(null,"test","test",(577538877))],[new cljs.core.Symbol(null,"mikron.schema","mikron.schema",(1753517621),null),new cljs.core.Symbol(null,"graph->hierarchy","graph->hierarchy",(832404546),null),"mikron/schema.cljc",(23),(1),(19),(19),cljs.core.list(new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Symbol(null,"graph","graph",(-1096336260),null)], null)),"Converts a graph to a hierarchy.",(cljs.core.truth_(mikron.schema.graph__GT_hierarchy)?mikron.schema.graph__GT_hierarchy.cljs$lang$test:null)])));})()
;
/**
 * The default type hierarchy.
 */
(function (){
mikron.schema.hierarchy = mikron.schema.graph__GT_hierarchy.call(null,cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"number","number",(1570378438)),new cljs.core.Keyword(null,"complex","complex",(1415610825)),new cljs.core.Keyword(null,"simple","simple",(-581868663)),new cljs.core.Keyword(null,"coll","coll",(1647737163)),new cljs.core.Keyword(null,"floating","floating",(-1978091029)),new cljs.core.Keyword(null,"=-comparable","=-comparable",(1594366861)),new cljs.core.Keyword(null,"primitive","primitive",(1884541424)),new cljs.core.Keyword(null,"integer","integer",(-604721710)),new cljs.core.Keyword(null,"built-in","built-in",(1245067766)),new cljs.core.Keyword(null,"aliased","aliased",(-125439273)),new cljs.core.Keyword(null,"identical?-comparable","identical?-comparable",(244199612)),new cljs.core.Keyword(null,"keyword-comparable","keyword-comparable",(1761750143))],[new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"integer","integer",(-604721710)),new cljs.core.Keyword(null,"floating","floating",(-1978091029))], null),new cljs.core.PersistentVector(null, 8, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"coll","coll",(1647737163)),new cljs.core.Keyword(null,"map","map",(1371690461)),new cljs.core.Keyword(null,"tuple","tuple",(-472667284)),new cljs.core.Keyword(null,"record","record",(-779106859)),new cljs.core.Keyword(null,"optional","optional",(2053951509)),new cljs.core.Keyword(null,"multi","multi",(-190293005)),new cljs.core.Keyword(null,"enum","enum",(1679018432)),new cljs.core.Keyword(null,"wrapped","wrapped",(1775172701))], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"primitive","primitive",(1884541424)),new cljs.core.Keyword(null,"aliased","aliased",(-125439273))], null),new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"list","list",(765357683)),new cljs.core.Keyword(null,"vector","vector",(1902966158)),new cljs.core.Keyword(null,"set","set",(304602554))], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"float","float",(-1732389368)),new cljs.core.Keyword(null,"double","double",(884886883))], null),new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"char","char",(-641587586)),new cljs.core.Keyword(null,"string","string",(-1989541586)),new cljs.core.Keyword(null,"symbol","symbol",(-1038572696))], null),new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"number","number",(1570378438)),new cljs.core.Keyword(null,"boolean","boolean",(-1919418404)),new cljs.core.Keyword(null,"binary","binary",(-1802232288)),new cljs.core.Keyword(null,"nil","nil",(99600501))], null),new cljs.core.PersistentVector(null, 8, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"byte","byte",(683775220)),new cljs.core.Keyword(null,"ubyte","ubyte",(-1022840731)),new cljs.core.Keyword(null,"short","short",(1928760516)),new cljs.core.Keyword(null,"ushort","ushort",(1434312932)),new cljs.core.Keyword(null,"int","int",(-1741416922)),new cljs.core.Keyword(null,"uint","uint",(521409576)),new cljs.core.Keyword(null,"long","long",(-171452093)),new cljs.core.Keyword(null,"varint","varint",(1231147450))], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"simple","simple",(-581868663)),new cljs.core.Keyword(null,"complex","complex",(1415610825))], null),cljs.core.keys.call(null,mikron.schema.aliases),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"boolean","boolean",(-1919418404)),new cljs.core.Keyword(null,"nil","nil",(99600501))], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"keyword","keyword",(811389747)),new cljs.core.Keyword(null,"enum","enum",(1679018432))], null)])); return (
new cljs.core.Var(function(){return mikron.schema.hierarchy;},new cljs.core.Symbol("mikron.schema","hierarchy","mikron.schema/hierarchy",(857531373),null),cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"ns","ns",(441598760)),new cljs.core.Keyword(null,"name","name",(1843675177)),new cljs.core.Keyword(null,"file","file",(-1269645878)),new cljs.core.Keyword(null,"end-column","end-column",(1425389514)),new cljs.core.Keyword(null,"column","column",(2078222095)),new cljs.core.Keyword(null,"line","line",(212345235)),new cljs.core.Keyword(null,"end-line","end-line",(1837326455)),new cljs.core.Keyword(null,"arglists","arglists",(1661989754)),new cljs.core.Keyword(null,"doc","doc",(1913296891)),new cljs.core.Keyword(null,"test","test",(577538877))],[new cljs.core.Symbol(null,"mikron.schema","mikron.schema",(1753517621),null),new cljs.core.Symbol(null,"hierarchy","hierarchy",(587061186),null),"mikron/schema.cljc",(15),(1),(27),(27),cljs.core.List.EMPTY,"The default type hierarchy.",(cljs.core.truth_(mikron.schema.hierarchy)?mikron.schema.hierarchy.cljs$lang$test:null)])));})()
;
