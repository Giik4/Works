using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

[RequireComponent(typeof(AudioSource))]
public class SimpleCollectibleScript : MonoBehaviour {

	public enum CollectibleTypes {Type1, Type2}; 

	public CollectibleTypes CollectibleType; 

	public bool rotate; 

	public float rotationSpeed;

	public AudioClip gema;

	public AudioClip municao;

	public GameObject collectEffect;
	


	void Start () {
		
	}
	

	void Update () {

		if (rotate)
			transform.Rotate (Vector3.up * rotationSpeed * Time.deltaTime, Space.World);

	}

	void OnTriggerEnter(Collider other)
	{
		if (other.tag == "Player") {
			Collect ();
		}
	}

	public void Collect()
	{
		
		if(collectEffect)
			Instantiate(collectEffect, transform.position, Quaternion.identity);

		
		if (CollectibleType == CollectibleTypes.Type1) {
			AudioSource.PlayClipAtPoint(gema, transform.position);
			scriptUI.gema++;
		}
		if (CollectibleType == CollectibleTypes.Type2) {
			AudioSource.PlayClipAtPoint(municao, transform.position);
			scriptUI.municao++;
		}

		Destroy (gameObject);
	}
}
