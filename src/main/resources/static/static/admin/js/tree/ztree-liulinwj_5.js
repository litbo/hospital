"use strict";

/**
 * @author Liulinwj
 * @licence MIT
 */
(function ($, ztree) {

  if (!ztree) {
    return;
  }

  var view = ztree._z.view;
  var makeNodeLineClassEx = view.makeNodeLineClassEx;
  var replaceSwitchClass = view.replaceSwitchClass;
  var makeNodeIcoClass = view.makeNodeIcoClass;
  var replaceIcoClass = view.replaceIcoClass;
  var asyncNode = view.asyncNode;


  function restore() {
    Object.assign(view, {
      makeNodeLineClassEx: makeNodeLineClassEx,
      replaceSwitchClass: replaceSwitchClass,
      makeNodeIcoClass: makeNodeIcoClass,
      replaceIcoClass: replaceIcoClass,
      asyncNode: asyncNode
    });
    return ztree;
  }

  function beautify() {
    var _ref = arguments.length <= 0 || arguments[0] === undefined ? {} : arguments[0];

    var _ref$ZTREE_SWITCH_OPE = _ref.ZTREE_SWITCH_OPEN;
    var ZTREE_SWITCH_OPEN = _ref$ZTREE_SWITCH_OPE === undefined ? "fa fa-caret-down" : _ref$ZTREE_SWITCH_OPE;
    var _ref$ZTREE_SWITCH_CLO = _ref.ZTREE_SWITCH_CLOSE;
    var ZTREE_SWITCH_CLOSE = _ref$ZTREE_SWITCH_CLO === undefined ? "fa fa-caret-right" : _ref$ZTREE_SWITCH_CLO;
    var _ref$ZTREE_ICON_OPEN = _ref.ZTREE_ICON_OPEN;
    var ZTREE_ICON_OPEN = _ref$ZTREE_ICON_OPEN === undefined ? "fa fa-folder-open" : _ref$ZTREE_ICON_OPEN;
    var _ref$ZTREE_ICON_CLOSE = _ref.ZTREE_ICON_CLOSE;
    var ZTREE_ICON_CLOSE = _ref$ZTREE_ICON_CLOSE === undefined ? "fa fa-folder" : _ref$ZTREE_ICON_CLOSE;
    var _ref$ZTREE_ICON_DOC = _ref.ZTREE_ICON_DOC;
    var ZTREE_ICON_DOC = _ref$ZTREE_ICON_DOC === undefined ? "fa fa-file-alt" : _ref$ZTREE_ICON_DOC;
    var _ref$ZTREE_ICON_ASYNC = _ref.ZTREE_ICON_ASYNC;
    var ZTREE_ICON_ASYNC = _ref$ZTREE_ICON_ASYNC === undefined ? "fa fa-spinner fa-spin" : _ref$ZTREE_ICON_ASYNC;


    view.asyncNode = function (setting, node, isSilent, callback) {
      var result = asyncNode(setting, node, isSilent, callback);
      if (node) {
        $("#" + node.id + "_ico").addClass(ZTREE_ICON_ASYNC);
      }
      return result;
    };

    view.makeNodeLineClassEx = function (treeNode) {
      var result = makeNodeLineClassEx(treeNode);
      if (treeNode.children || treeNode.isParent) {
        var iconClass = treeNode.open ? ZTREE_SWITCH_OPEN : ZTREE_SWITCH_CLOSE;
        return result + " " + iconClass + " ";
      }
      return result;
    };

    view.replaceSwitchClass = function (node, obj, newName) {
      replaceSwitchClass(node, obj, newName);
      switch (newName) {
          // If icon classes contains more than one part,
          // use toggle class will make public parts removed.
        case "open":
          $(obj).removeClass(ZTREE_SWITCH_CLOSE).addClass(ZTREE_SWITCH_OPEN);
          break;
        case "close":
          $(obj).removeClass(ZTREE_SWITCH_OPEN).addClass(ZTREE_SWITCH_CLOSE);
          break;
        default:
      }
    };

    view.makeNodeIcoClass = function (setting, node) {
      var result = makeNodeIcoClass(setting, node);
      if (result.includes("ico_docu")) {
        return result + " " + (node.icon || ZTREE_ICON_DOC);
      }
      if (result.includes("ico_close")) {
        return result + " " + (node.iconClose || node.icon || ZTREE_ICON_CLOSE);
      }
      if (result.includes("ico_open")) {
        return result + " " + (node.iconOpen || node.icon || ZTREE_ICON_OPEN);
      }
      return result;
    };

    view.replaceIcoClass = function (node, obj, newName) {
      replaceIcoClass(node, obj, newName);
      switch (newName) {
        case "open":
          $(obj).removeClass(node.iconClose || node.icon || ZTREE_ICON_CLOSE).addClass(node.iconOpen || node.icon || ZTREE_ICON_OPEN);
          break;
        case "close":
          $(obj).removeClass(node.iconOpen || node.icon || ZTREE_ICON_OPEN).addClass(node.iconClose || node.icon || ZTREE_ICON_CLOSE);
          break;
        default:
      }
    };

    return ztree;
  }

  return Object.assign(ztree, { beautify: beautify, restore: restore });
})(jQuery, jQuery && jQuery.fn.zTree);