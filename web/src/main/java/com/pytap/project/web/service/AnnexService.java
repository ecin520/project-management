package com.pytap.project.web.service;

import com.pytap.project.entity.Annex;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/4/30 13:53
 */
public interface AnnexService {

	/**
	 * 添加附件
	 * @param annex 附件实体
	 * @return Integer 返回结果
	 * */
	Integer insertAnnex(Annex annex);

	/**
	 * 主键删除附件
	 * @param id 主键
	 * @return Integer 返回结果
	 * */
	Integer deleteAnnex(Long id);

	/**
	 * 更新附件
	 * @param annex 附件实体
	 * @return Integer 返回结果
	 * */
	Integer updateAnnex(Annex annex);

	/**
	 * 列出指定task的所有附件
	 * @param id taskId
	 * @return List<Annex> 附件列表
	 * */
	List<Annex> listAnnexesByTaskId(Long id);

}
