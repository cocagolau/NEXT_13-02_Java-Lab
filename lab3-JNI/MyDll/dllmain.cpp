// dllmain.cpp : DLL ���� ���α׷��� �������� �����մϴ�.
#include "stdafx.h"
#include "JNILoader.h"

BOOL APIENTRY DllMain( HMODULE hModule,
                       DWORD  ul_reason_for_call,
                       LPVOID lpReserved
					 )
{
	switch (ul_reason_for_call)
	{
	case DLL_PROCESS_ATTACH:
	case DLL_THREAD_ATTACH:
	case DLL_THREAD_DETACH:
	case DLL_PROCESS_DETACH:
		break;
	}
	return TRUE;
}

JNIEXPORT void JNICALL Java_JNILoader_greet(JNIEnv *env, jobject obj) {
	char cSerialNumber[16];
	DWORD dwSerialNumber;
	GetVolumeInformation("C:\\", NULL, 0, &dwSerialNumber, NULL, NULL, NULL, 0);

	sprintf_s(cSerialNumber, "%8x", dwSerialNumber);
	printf("----------------------------------\n");
	printf("Volume SerialNumber = %s\n", cSerialNumber);
	printf("----------------------------------\n");
	return;
}