package com.worthto.ecps.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.worthto.ecps.model.EbBrand;
import com.worthto.ecps.model.EbCat;
import com.worthto.ecps.model.EbFeature;
import com.worthto.ecps.model.EbItem;
import com.worthto.ecps.model.EbItemClob;
import com.worthto.ecps.model.EbParaValue;
import com.worthto.ecps.model.EbSku;
import com.worthto.ecps.model.EbSpecValue;
import com.worthto.ecps.service.IEbBrandService;
import com.worthto.ecps.service.IEbCatService;
import com.worthto.ecps.service.IEbFeatureService;
import com.worthto.ecps.service.IEbItemClobService;
import com.worthto.ecps.service.IEbItemService;
import com.worthto.ecps.utils.EcpsUtils;
import com.worthto.ecps.utils.Page;
import com.worthto.ecps.utils.QueryCondition;

@Controller
@RequestMapping("/item")
public class EbItemController {
	@Autowired
	private IEbBrandService brandService;
	@Autowired
	private IEbItemService itemService;
	@Autowired
	private IEbCatService catService;
	@Autowired
	private IEbFeatureService featureService;
	@Autowired
	private IEbItemClobService itemClobService;

	@RequestMapping("/brand/index.do")
	public String toIndex() {
		return "item/index";
	}

	// ��ת�����Ʒ�Ƶ�ҳ��
	@RequestMapping("/brand/addBrandUI.do")
	public String addbrandUI() {
		return "item/addbrand";
	}

	// �����ύ�����Ʒ�Ƶı�
	@RequestMapping("/brand/addBrand.do")
	public String addbrandUI(EbBrand brand) {
		brandService.saveEbBrand(brand);
		return "redirect:listBrand.do";
	}

	// ��ת��Ʒ���б�
	@RequestMapping("/brand/listBrand.do")
	public String listBrand(Model model) {
		List<EbBrand> brandList = brandService.selectEbBrandAll();
		model.addAttribute("brandList", brandList);
		model.addAttribute("hostPath", EcpsUtils.readProp("file_host_path"));
		return "item/listbrand";
	}

	// �ж�Ʒ�������Ƿ��Ѿ�����
	@RequestMapping("/brand/nameExist.do")
	public void nameExist(Model model, PrintWriter out, String brandName) {
		String msg = "yes";
		model.addAttribute("msg", msg);
		List<EbBrand> brands = brandService.selectEbBrandByName(brandName);
		if (brands.size() > 0) {
			msg = "no";
		}
		out.print(msg);
	}

	// ɾ������Ʒ��
	@RequestMapping("/brand/deleteBrand.do")
	public String deleteBrand(Long brandId) {
		System.out.println(brandId);
		brandService.deleteBrandById(brandId);
		return "redirect:listBrand.do";
	}

	@RequestMapping("/brand/editBrandUI.do")
	public String editBrand(Model model, Long brandId) {
		System.out.println(brandId);
		model.addAttribute("hostPath", EcpsUtils.readProp("file_host_path"));
		model.addAttribute("brandId", brandId);
		EbBrand brand = brandService.selectEbBrandById(brandId);
		model.addAttribute("brand", brand);
		return "item/editbrand";
	}

	@RequestMapping("/brand/updateBrand.do")
	public String editBrand(EbBrand brand, String oldPath) {
		// �ͻ��˸�����ͼƬ��ɾ��ͼƬ
		if (!"".equals(brand.getImgs())) {

			brandService.selectEbBrandById(brand.getBrandId());
			if (StringUtils.isNotBlank(brand.getImgs())) {
				Client client = new Client();// ����JerSey�ͻ���
				try {
					WebResource wr1 = client.resource(EcpsUtils
							.readProp("file_host_path") + oldPath);// ָ����Դ��·��
					wr1.delete();
				} catch (Exception e) {
					// �����쳣����ֹ�����޸�ɾ��·��
					e.printStackTrace();
				}
			}
		} else {
			brand.setImgs(null);// Ϊ""������Ϊnull�������ݿⲻ���´�����
		}
		brandService.updateEbBrand(brand);
		return "redirect:listBrand.do";
	}

	@RequestMapping("/queryItemByCondtion.do")
	public String listItem(Model model, HttpServletRequest request,
			QueryCondition queryCondition) {
		List<EbBrand> bList = brandService.selectEbBrandAll();
		model.addAttribute("bList", bList);

		Page page = itemService.selectItemByCondition(queryCondition);
		model.addAttribute("page", page);
		model.addAttribute("queryCondition", queryCondition);
		return "item/listItem";
	}

	// ����鿴��Ʒ������
	@RequestMapping("/viewItem.do")
	public String viewItem(Model model, Long itemId) {
		System.out.println(itemId);
		EbItem ebItem = itemService.selectItemById(itemId);
		model.addAttribute("ebItem", ebItem);
		EbCat ebCat = catService.selectCatById(ebItem.getCatId());
		model.addAttribute("ebCat", ebCat);
		List<EbBrand> blist = brandService.selectEbBrandAll();
		model.addAttribute("blist", blist);

		return "/item/viewItem";
	}

	// ������ת�������Ʒҳ�������
	@RequestMapping("/toAddItem.do")
	public String toAddItem(Model model) {
		List<EbBrand> bList = brandService.selectEbBrandAll();
		model.addAttribute("bList", bList);
		List<EbFeature> paraList = featureService.selectCommFeatures();
		List<EbFeature> specList = featureService.selectSpecFeatures();
		model.addAttribute("paraList", paraList);
		model.addAttribute("specList", specList);
		return "/item/addItem";
	}

	// ���������Ʒ����
	@RequestMapping("/addItem.do")
	public String addItem(Model model, EbItem item, EbItemClob itemClob,
			EbParaValue paraValue, EbSku sku, EbSpecValue specValue,
			EbFeature feature) {
		// ׼������Ʒ�����ݲ���
		item.setItemNo(new SimpleDateFormat("yyyyMMddss").format(new Date()));
		itemService.insert(item);
		// ׼������Ʒ���ֶε����ݲ���
		itemClob.setItemId(item.getItemId());
		itemClobService.insert(itemClob);

		return "redirect:/item/queryItemByCondtion.do";
	}

}
