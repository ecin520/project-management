package com.pytap.project.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.Log;
import com.pytap.project.entity.Annex;
import com.pytap.project.utils.JsonUtil;
import com.pytap.project.web.service.AnnexService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Ecin520
 * @date 2020/5/9 17:18
 */
@RestController
@PreAuthorize("hasRole('R_USER')")
@RequestMapping("/web/annex")
public class AnnexController {

	@Resource
	private AnnexService annexService;

	@Log(value = "添加附件")
	@RequestMapping(value = "/insertAnnex", method = RequestMethod.POST)
	public JSONObject insertAnnex(@RequestBody Annex annex) {
		return annexService.insertAnnex(annex) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "删除附件")
	@RequestMapping(value = "/deleteAnnex", method = RequestMethod.GET)
	public JSONObject deleteAnnex(Long id) {
		return annexService.deleteAnnex(id) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "更新附件")
	@RequestMapping(value = "/updateAnnex", method = RequestMethod.POST)
	public JSONObject updateAnnex(@RequestBody Annex annex) {
		return annexService.updateAnnex(annex) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@Log(value = "获取任务附件")
	@RequestMapping(value = "/listAnnexesByTaskId", method = RequestMethod.GET)
	public JSONObject listAnnexesByTaskId(Long id) {
		return JsonUtil.backObject(200, annexService.listAnnexesByTaskId(id));
	}
}
